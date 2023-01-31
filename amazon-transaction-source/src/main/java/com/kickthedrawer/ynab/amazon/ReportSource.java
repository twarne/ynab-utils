package com.kickthedrawer.ynab.amazon;

import static java.lang.String.format;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class ReportSource implements Supplier<Pair<ReportType, Path>> {
    private static final Predicate<Path> CSV_FILE_FILTER = p -> p.endsWith("csv");

    private final static Map<String, ReportType> REPORT_TYPE_RESOLVER;

    @Value("${reports.directory}")
    private String reportsDirectory;

    private Iterator<Path> reports;


    static {
        REPORT_TYPE_RESOLVER = new HashMap<>();
        REPORT_TYPE_RESOLVER.put("Order Date,Order ID,Title,Category,ASIN/ISBN,UNSPSC Code", ReportType.ORDER);
        REPORT_TYPE_RESOLVER.put("Order ID,Order Date,Title,Category,ASIN/ISBN,Website,Purchase Order Number", ReportType.REFUND);
        REPORT_TYPE_RESOLVER.put("Order Date,Order ID,Payment Instrument Type,Website,Purchase Order Number", ReportType.SHIPMENT);
    }

    private void init() {
        synchronized (REPORT_TYPE_RESOLVER) {
            if (reports == null) {
                try {
                    log.info(format("Initializing reports from %s", reportsDirectory));
                    reports = Files.list(Paths.get(reportsDirectory)).filter(CSV_FILE_FILTER).iterator();
                } catch (IOException e) {
                    log.log(Level.WARNING,
                            format("Failed to load reports from %s: %s", reportsDirectory, e.getMessage()),
                            e);
                }
            }
        }
    }
    
    @Override
    public Pair<ReportType, Path> get() {
        if(reports == null) {
            log.info("Initializing report source");
            init();
        }
        if(reports.hasNext()) {
            Path reportPath = reports.next();
            return Pair.of(getReportType(reportPath), reportPath);
        }
        log.info("Reports exhausted; resetting");
        reports = null;
        return null;
    }

    private ReportType getReportType(Path reportPath) {
        try(BufferedReader reader = Files.newBufferedReader(reportPath)) {
            String firstLine = reader.readLine();
            log.info(format("Report %s has first line '%s'", reportPath, firstLine));
            for(Map.Entry<String, ReportType> entry : REPORT_TYPE_RESOLVER.entrySet()) {
                log.info(format("Checking type %s", entry.getValue()));
                if(firstLine.startsWith(entry.getKey())) {
                    log.info(format("Report %s matched type %s", reportPath.toString(), entry.getValue()));
                    return entry.getValue();
                }
            }
        } catch(IOException e) {
            log.log(Level.WARNING, format("Unable to open %s to determine report type", reportPath.toString()), e);
        }
        return null;
    }

}
