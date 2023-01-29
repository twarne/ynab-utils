package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public abstract class ReportItem {

    private String buyerName;

    private String groupName;

    private LocalDate orderDate;

    private String orderId;

    @Column(nullable = true)
    private String purchaseOrderNumber;

    private String website;

    @Column(unique = true)
    private String itemHash;
}
