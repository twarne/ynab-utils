package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import com.kickthedrawer.ynab.amazon.helper.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class ReportItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = true)
    @CsvBindByName(column = "Buyer Name")
    private String buyerName;

    @Column(nullable = true)
    @CsvBindByName(column = "Group Name")
    private String groupName;

    @CsvCustomBindByName(column = "Order Date", converter = LocalDateConverter.class)
    private LocalDate orderDate;

    @CsvBindByName(column = "Order ID")
    private String orderId;

    @Column(nullable = true)
    @CsvBindByName(column = "Purchase Order Number")
    private String purchaseOrderNumber;

    @CsvBindByName(column = "Website")
    private String website;
}
