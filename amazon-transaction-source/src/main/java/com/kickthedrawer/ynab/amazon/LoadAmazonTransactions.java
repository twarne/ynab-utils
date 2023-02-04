package com.kickthedrawer.ynab.amazon;

import static java.lang.String.format;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.logging.Level;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kickthedrawer.ynab.amazon.persistence.model.Order;
import com.kickthedrawer.ynab.amazon.persistence.model.Refund;
import com.kickthedrawer.ynab.amazon.persistence.model.ReportItem;
import com.kickthedrawer.ynab.amazon.persistence.model.Shipment;
import com.kickthedrawer.ynab.amazon.persistence.repositories.OrderRepository;
import com.kickthedrawer.ynab.amazon.persistence.repositories.RefundRepository;
import com.kickthedrawer.ynab.amazon.persistence.repositories.ShipmentRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
        try {
            processReports();
        } catch(Exception e) {
            log.log(Level.WARNING,
                    format("Error while processing reports: %s (%s)", e.getClass().getName(), e.getMessage()));
        }
        
        logStats();

        log.info("Finished converting reports");
    }

    private void processReports() throws IOException {
        Pair<ReportType, Path> reportPair = reportSource.get();
        int reportCount = 0;
        while(reportPair != null) {
            reportCount++;
            process(reportPair.getLeft(), reportPair.getRight());
            reportPair = reportSource.get();
        }
        log.info(format("Processed %d reports", reportCount));
    }

    private void process(ReportType reportType, Path reportPath) throws IOException{
        log.info(format("Processing report (%s) %s", reportType, reportPath.toString()));
        try(Reader reader = Files.newBufferedReader(reportPath)) {
            CsvToBean<ReportItem> beanProcessor = new CsvToBeanBuilder<ReportItem>(reader).withType(reportType.getType()).build();
            Iterator<ReportItem> itemIterator = beanProcessor.iterator();
            ReportItem item = null;
            while(itemIterator.hasNext()) {
                item = itemIterator.next();
                saveItem(item);
            }
        }
    }

    private void saveItem(ReportItem item) {
        if(item instanceof Order) {
            log.info(format("Saving order %s", item.getOrderId()));
            orderRepository.save((Order)item);
        } else if(item instanceof Shipment) {
            log.info(format("Saving shipment %s", item.getOrderId()));
            shipmentRepository.save((Shipment)item);
        } else if(item instanceof Refund) {
            log.info(format("Saving refund %s", item.getOrderId()));
            refundRepository.save((Refund)item);
        } else if(item == null) {
            log.warning(format("Attempt to save null item"));
        } else {
            log.severe(format("Unknown item type: %s", item.getClass().getName()));
        }
    }

    private void logStats() {
        log.info(format("Now there are %d shipments in the db", shipmentRepository.count()));
        log.info(format("Now there are %d refunds in the db", refundRepository.count()));
        log.info(format("Now there are %d orders in the db", orderRepository.count()));
    }

}
