package com.kickthedrawer.ynab.amazon;

import static java.lang.String.format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kickthedrawer.ynab.amazon.persistence.model.Shipment;
import com.kickthedrawer.ynab.amazon.persistence.repositories.OrderRepository;
import com.kickthedrawer.ynab.amazon.persistence.repositories.RefundRepository;
import com.kickthedrawer.ynab.amazon.persistence.repositories.ShipmentRepository;

import lombok.extern.java.Log;
import picocli.CommandLine.Command;

@Log
@Component
@Command(name = "LoadAmazonTransactions")
public class LoadAmazonTransactions implements Runnable {


    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RefundRepository refundRepository;

    @Autowired
    private ReportSource reportSource;

        @Value("${reports.archive}")
        private String archiveDirectory;

    public void run() {
        log.info("Converting Amazon Order to Transactions");
        processReports();

        Shipment shipment = new Shipment();
        shipment.setBuyerName("Tom Warne");
        shipment.setCarrierNameTrackingNumber("12345");
        shipment.setGroupName("Five");
        shipment.setItemHash("nulABCDEl");
        shipment.setOrderDate(LocalDate.now());
        shipment.setOrderId("12345");
        shipment.setOrderStatus("Done");
        shipment.setPaymentInstrumentType("Visa");
        shipment.setShipmentDate(LocalDate.now());
        shipment.setSubtotal(5.0f);
        shipment.setTaxBeforePromotions(5.0f);
        shipment.setTaxCharged(5.0f);
        shipment.setTotalCharged(5.0f);
        shipment.setTotalPromotions(5.0f);
        shipment.setWebsite("some site");
        shipment.setItemHash("seventy");

        shipmentRepository.save(shipment);

        log.info(format("Now there are %d shipments in the db", shipmentRepository.count()));
        log.info(format("Now there are %d refunds in the db", refundRepository.count()));
        log.info(format("Now there are %d orders in the db", orderRepository.count()));
    }

    private void processReports() throws IOException {
        Pair<ReportType, Path> reportPair = reportSource.get();
        while(reportPair != null) {
            process(reportPair.getLeft(), reportPair.getRight());
        }
    }

    private void process(ReportType reportType, Path reportPath) {
        log.info(format("Processing report %s", reportPath.toString()));
    }

}
