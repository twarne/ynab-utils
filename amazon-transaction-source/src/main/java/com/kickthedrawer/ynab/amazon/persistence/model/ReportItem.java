package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public abstract class ReportItem {

    @Column(nullable = true)
    @CsvBindByName(column = "Buyer Name")
    private String buyerName;

    @Column(nullable = true)
    @CsvBindByName(column = "Group Name")
    private String groupName;

    @CsvBindByName(column = "Order Date")
    private LocalDate orderDate;

    @CsvBindByName(column = "Order ID")
    private String orderId;

    @Column(nullable = true)
    @CsvBindByName(column = "Purchase Order Number")
    private String purchaseOrderNumber;

    @CsvBindByName(column = "Website")
    private String website;

    @Column(unique = true)
    private String itemHash;
}
