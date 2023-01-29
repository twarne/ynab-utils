package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="orders")
public class Order extends LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = true)
    private String carrierNameTrackingNumber;

    private String condition;

    private String currency;

    private String exemptionOptOut;

    private float itemSubtotal;

    private float itemSubtotalTax;

    private float itemTotal;

    private float listPricePerUnit;

    @Column(nullable = true)
    private String orderStatus;

    private String orderingCustomerEmail;

    private String paymentInstrumentType;

    @Column(nullable = true)
    private String poLineNumber;

    private float purchasePricePerUnit;

    private LocalDate releaseDate;

    private LocalDate shipmentDate;

    @Column(nullable = true)
    private String shippingAddressCity;

    @Column(nullable = true)
    private String shippingAddressName;

    @Column(nullable = true)
    private String shippingAddressState;

    @Column(nullable = true)
    private String shippingAddressStreet1;

    @Column(nullable = true)
    private String shippingAddressStreet2;

    @Column(nullable = true)
    private String shippingAddressZip;

    private String unspscCode;
}
