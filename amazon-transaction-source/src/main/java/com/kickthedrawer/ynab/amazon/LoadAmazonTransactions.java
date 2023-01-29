package com.kickthedrawer.ynab.amazon;

import static java.lang.String.format;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.function.Predicate;

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

    private static final Predicate<Path> CSV_FILE_FILTER = p -> p.endsWith("csv");

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RefundRepository refundRepository;

    @Value("${reports.directory}")
        private String reportsDirectory;

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
        Path reportsDirectoryPath = Paths.get(reportsDirectory);
        Files.list(reportsDirectoryPath).filter(CSV_FILE_FILTER).forEach(this::process);
    }

    private void process(Path reportPath) {
        log.info(format("Processing report %s", reportPath.toString()));
    }

}
