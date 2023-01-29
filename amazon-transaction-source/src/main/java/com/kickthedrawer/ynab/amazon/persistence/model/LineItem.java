package com.kickthedrawer.ynab.amazon.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class LineItem extends ReportItem {
    private String asinIsbn;
    private String category;
    private long quantity;
    private String seller;
    private String sellerCredentials;
    private String taxExemptionApplied;
    private String title;
    
}
