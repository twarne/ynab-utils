package com.kickthedrawer.ynab.converter;

import static java.lang.String.format;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kickthedrawer.ynab.ApiClient;
import com.kickthedrawer.ynab.Configuration;
import com.kickthedrawer.ynab.amazon.persistence.model.Order;
import com.kickthedrawer.ynab.amazon.persistence.model.Refund;
import com.kickthedrawer.ynab.amazon.persistence.model.ReportItem;
import com.kickthedrawer.ynab.amazon.persistence.model.Shipment;
import com.kickthedrawer.ynab.amazon.persistence.repositories.OrderRepository;
import com.kickthedrawer.ynab.amazon.persistence.repositories.RefundRepository;
import com.kickthedrawer.ynab.amazon.persistence.repositories.ShipmentRepository;
import com.kickthedrawer.ynab.api.BudgetsApi;
import com.kickthedrawer.ynab.auth.ApiKeyAuth;
import com.kickthedrawer.ynab.client.YnabClient;
import com.kickthedrawer.ynab.converter.util.DateOptionConverter;
import com.kickthedrawer.ynab.converter.util.FilterOptionConverter;
import com.kickthedrawer.ynab.converter.util.TransactionFilter;
import com.kickthedrawer.ynab.model.SaveTransaction;
import com.kickthedrawer.ynab.model.SaveTransaction.ClearedEnum;

import lombok.extern.java.Log;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Log
@Component
@Command(name = "ConvertAmazonTransactions")
public class ConvertAmazonTransactions implements Runnable {

    private static final String DEFAULT_PAYEE_NAME = "Amazon.com";

    private static final String ID_HASH_ALGO = "SHA256";

    private static final Consumer<Order> ORDER_LOGGER = order -> log
            .info(format("\tOrder: %s / %s / %s", order.getId(), order.getOrderDate(), order.getTitle()));

    private static final Consumer<Refund> REFUND_LOGGER = refund -> log
            .info(format("\tRefund: %s / %s / %s", refund.getId(), refund.getOrderDate(), refund.getTitle()));

    private static final Consumer<Shipment> SHIPMENT_LOGGER = shipment -> log.info(
            format("\tShipment: %s / %s / %s", shipment.getId(), shipment.getOrderId(),
                            shipment.getShippingCharge()));

    private static final Consumer<Shipment> PROMOTION_LOGGER = shipment -> log.info(
            format("\tPromotion: %s / %s / %s", shipment.getId(), shipment.getOrderId(),
                            shipment.getTotalPromotions()));

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private RefundRepository refundRepo;

    @Autowired
    private ShipmentRepository shipmentRepo;

    @Autowired
    private YnabClient ynabClient;

    @Option(names = { "-s", "--startDate" }, converter = DateOptionConverter.class)
    private LocalDate startDate;

    @Option(names = { "-e", "--endDate" }, converter = DateOptionConverter.class)
    private LocalDate endDate;

    @Option(names = { "-f", "--filter" }, converter = FilterOptionConverter.class)
    private TransactionFilter[] filters;

    @Option(names = { "-c", "--cleared" })
    private boolean cleared;

    @Value("${amazonConverter.accountName}")
    private String accountName;

    @Override
    public void run() {
        log.info("Converting Amazon transactions");

        log.info(format("Searching between %s and %s", startDate, endDate));

        List<SaveTransaction> transactions = new ArrayList<>();

        Map<String, Float> itemSubtotals = new HashMap<>();
        Map<String, Float> itemTotals = new HashMap<>();
        Map<String, Float> shipmentShippingTotals = new HashMap<>();
        Map<String, Float> shipmentPromotionTotals = new HashMap<>();
        Map<String, Float> shipmentTotals = new HashMap<>();
        Map<String, Float> shipmentSubtotals = new HashMap<>();
        Map<String, LocalDate> orderDates = new HashMap<>();

        List<Order> orders = orderRepo.findByOrderDateBetween(startDate, endDate);
        List<SaveTransaction> orderTransactions = convertTransactions(orders.stream(),
                Order::getItemTotal, this::createOrderTransaction, ORDER_LOGGER,
                Arrays.asList(Pair.of(itemSubtotals, Order::getItemSubtotal),
                        Pair.of(itemTotals, Order::getItemTotal)));
        transactions.addAll(orderTransactions);

        List<Refund> refunds = refundRepo.findByOrderDateBetween(startDate, endDate);
        List<SaveTransaction> refundTransactions = convertTransactions(refunds.stream(),
                Refund::getRefundAmount, this::createRefundTransaction, REFUND_LOGGER, Collections.emptyList());
        transactions.addAll(refundTransactions);

        List<Shipment> shipments = shipmentRepo.findByOrderDateBetween(startDate, endDate);
        List<SaveTransaction> shipmentTransactions = convertTransactions(shipments.stream(),
                Shipment::getShippingCharge, this::createShipmentTransaction, SHIPMENT_LOGGER,
                Arrays.asList(Pair.of(shipmentShippingTotals, Shipment::getShippingCharge)));
        transactions.addAll(shipmentTransactions);

        List<SaveTransaction> promotionTransactions = convertTransactions(shipments.stream(),
                Shipment::getTotalPromotions, this::createPromotionTransaction, PROMOTION_LOGGER,
                Arrays.asList(Pair.of(shipmentPromotionTotals, Shipment::getTotalPromotions)));
        transactions.addAll(promotionTransactions);
        
        shipments.stream().peek(shipment -> orderDates.put(shipment.getOrderId(), shipment.getOrderDate()))
                .forEach(applyTotalFuncs(Arrays.asList(Pair.of(shipmentSubtotals, Shipment::getSubtotal),
                        Pair.of(shipmentTotals, Shipment::getTotalCharged))));

        List<SaveTransaction> miscTransactions = getMiscTransactions(itemSubtotals, itemTotals, shipmentSubtotals,
                shipmentTotals, shipmentShippingTotals, shipmentPromotionTotals, orderDates);
        transactions.addAll(miscTransactions);

        log.info(format("Found %d transactions to save", transactions.size()));

        if(!transactions.isEmpty()) {
                try {
                ynabClient.addTransactions(accountName, transactions);
                } catch(ApiException e) {

                }
        }
    }

    private <T extends ReportItem> List<SaveTransaction> convertTransactions(Stream<T> itemStream,
            Function<T, Float> amountFunc, Function<T, SaveTransaction> createTransactionFunc, Consumer<T> logFunc,
            List<Pair<Map<String, Float>, Function<T, Float>>> totalPairs) {
        return itemStream.filter(item -> amountFunc.apply(item) > 0)
                .peek(logFunc)
                .peek(applyTotalFuncs(totalPairs))
                .map(createTransactionFunc)
                .collect(Collectors.toList());
    }

    private <T extends ReportItem> Consumer<T> applyTotalFuncs(
            List<Pair<Map<String, Float>, Function<T, Float>>> totalPairs) {
        return item -> {
            for (Pair<Map<String, Float>, Function<T, Float>> totalMapFunc : totalPairs) {
                Map<String, Float> totalMap = totalMapFunc.getLeft();
                Function<T, Float> amountFunc = totalMapFunc.getRight();
                totalMap.put(item.getOrderId(),
                        totalMap.getOrDefault(item.getOrderId(), 0.0f) + amountFunc.apply(item));
            }
        };
    }

    private List<SaveTransaction> getMiscTransactions(Map<String, Float> itemSubtotals, Map<String, Float> itemTotals,
            Map<String, Float> shipmentSubtotals, Map<String, Float> shipmentTotals,
            Map<String, Float> shipmentShippingTotals, Map<String, Float> shipmentPromotionTotals,
            Map<String, LocalDate> orderDates) {
        List<SaveTransaction> miscTransactions = new ArrayList<>();
        for(Map.Entry<String, Float> itemSubtotalEntry : itemSubtotals.entrySet()) {
            String orderId = itemSubtotalEntry.getKey();
            float shipmentSubtotal = shipmentSubtotals.getOrDefault(orderId, 0.0f);
            if(Math.abs(shipmentSubtotal - itemSubtotalEntry.getValue()) > 0.01) {
                continue;
            }

            float itemTotal = itemTotals.getOrDefault(orderId, 0.0f);
            float shipmentPromotionTotal = shipmentPromotionTotals.getOrDefault(orderId, 0.0f);
            float shipmentShippingTotal = shipmentShippingTotals.getOrDefault(orderId, 0.0f);
            float shipmentTotal = shipmentTotals.getOrDefault(orderId, 0.0f);
            LocalDate orderDate = orderDates.get(orderId);

            float unaccountedDifference = shipmentTotal - (itemTotal + shipmentShippingTotal - shipmentPromotionTotal);
        
            if(unaccountedDifference > 0.01) {
                miscTransactions.add(createMiscTransaction(orderId, orderDate, unaccountedDifference));
            }
        }

        return miscTransactions;
    }

    private SaveTransaction createOrderTransaction(Order order) {
        SaveTransaction txn = new SaveTransaction();
        txn.setAmount(Long.valueOf(Math.round(-order.getItemTotal() * 1000)));
        txn.setCleared(cleared ? ClearedEnum.CLEARED : ClearedEnum.UNCLEARED);
        txn.setDate(order.getOrderDate());
        txn.setImportId(generateImportId(order.getClass().getSimpleName(), order.getOrderId(),
                order.getOrderDate().toString(), order.getAsinIsbn(), order.getTitle(), order.getSeller(),
                String.valueOf(order.getQuantity()), String.valueOf(order.getItemTotal())));
        txn.setMemo(format("%s%s", order.getQuantity() > 1 ? format("%d x ", order.getQuantity()) : "",
                order.getTitle().substring(0, 200)));
        txn.setPayeeName(StringUtils.isEmpty(order.getSeller()) ? order.getSeller() : DEFAULT_PAYEE_NAME);
        return txn;
    }

    private SaveTransaction createRefundTransaction(Refund refund) {
        SaveTransaction txn = new SaveTransaction();
        txn.setAmount(Long.valueOf(Math.round((refund.getRefundAmount() + refund.getRefundTaxAmount()) * 1000)));
        txn.setCleared(cleared ? ClearedEnum.CLEARED : ClearedEnum.UNCLEARED);
        txn.setDate(refund.getRefundDate());
        txn.setImportId(generateImportId(refund.getClass().getSimpleName(), refund.getOrderId(),
                refund.getRefundDate().toString(), refund.getAsinIsbn(), refund.getTitle(), refund.getSeller(),
                String.valueOf(refund.getQuantity()), String.valueOf(refund.getRefundAmount())));
        txn.setMemo(format("%s%s", refund.getQuantity() > 1 ? format("%d x ", refund.getQuantity()) : "",
                refund.getTitle().substring(0, 200)));
        txn.setPayeeName(StringUtils.isEmpty(refund.getSeller()) ? refund.getSeller() : DEFAULT_PAYEE_NAME);
        return txn;
    }

    private SaveTransaction createShipmentTransaction(Shipment shipment) {
        SaveTransaction txn = new SaveTransaction();
        txn.setAmount(Long.valueOf(Math.round(-shipment.getShippingCharge() * 1000)));
        txn.setCleared(cleared ? ClearedEnum.CLEARED : ClearedEnum.UNCLEARED);
        txn.setDate(shipment.getOrderDate());
        txn.setImportId(
                generateImportId(shipment.getClass().getSimpleName(), shipment.getOrderId(),
                        shipment.getOrderDate().toString(),
                        String.valueOf(shipment.getShippingCharge())));
        txn.setMemo(format("Shipping for %s", shipment.getOrderId()));
        txn.setPayeeName(DEFAULT_PAYEE_NAME);
        return txn;
    }

    private SaveTransaction createPromotionTransaction(Shipment shipment) {
        SaveTransaction txn = new SaveTransaction();
        txn.setAmount(Long.valueOf(Math.round(shipment.getTotalPromotions() * 1000)));
        txn.setCleared(cleared ? ClearedEnum.CLEARED : ClearedEnum.UNCLEARED);
        txn.setDate(shipment.getOrderDate());
        txn.setImportId(
                generateImportId("promotion", shipment.getOrderId(),
                        shipment.getOrderDate().toString(),
                        String.valueOf(shipment.getTotalPromotions())));
        txn.setMemo(format("Promotion for %s", shipment.getOrderId()));
        txn.setPayeeName(DEFAULT_PAYEE_NAME);
        return txn;
    }

    private SaveTransaction createMiscTransaction(String orderId, LocalDate orderDate, float amount) {
        SaveTransaction txn = new SaveTransaction();
        txn.setAmount(Long.valueOf(Math.round(amount * 1000)));
        txn.setCleared(cleared ? ClearedEnum.CLEARED : ClearedEnum.UNCLEARED);
        txn.setDate(orderDate);
        txn.setImportId(
                generateImportId("misc", orderId,
                        orderDate.toString(),
                        String.valueOf(amount)));
        txn.setMemo(format("Misc adjustment for %s", orderId));
        txn.setPayeeName(DEFAULT_PAYEE_NAME);
        return txn;
    }

    private String generateImportId(String... hashComponents) {
        try {
            MessageDigest hash = MessageDigest.getInstance(ID_HASH_ALGO);
            Arrays.asList(hashComponents).stream().filter(StringUtils::isNotBlank).map(String::getBytes)
                    .forEach(hash::update);
            return Hex.encodeHexString(hash.digest()).substring(0, 36);
        } catch (NoSuchAlgorithmException e) {
            log.log(Level.WARNING, format("Failed to create hash with algorithm %s", ID_HASH_ALGO), e);
        }
        return null;
    }

}
