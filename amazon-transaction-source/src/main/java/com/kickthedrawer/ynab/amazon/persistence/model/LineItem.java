package com.kickthedrawer.ynab.amazon.persistence.model;

import com.opencsv.bean.CsvBindByName;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class LineItem extends ReportItem {
    @Column(nullable = true)
    @CsvBindByName(column = "ASIN/ISBN")
    private String asinIsbn;
    @CsvBindByName(column = "Category")
    private String category;
    @CsvBindByName(column = "Quantity")
    private long quantity;
    @CsvBindByName(column = "Seller")
    private String seller;
    @CsvBindByName(column = "Seller Credentials")
    private String sellerCredentials;
    @CsvBindByName(column = "Tax Exemption Applied")
    private String taxExemptionApplied;
    @CsvBindByName(column = "Title")
    private String title;
    
}
