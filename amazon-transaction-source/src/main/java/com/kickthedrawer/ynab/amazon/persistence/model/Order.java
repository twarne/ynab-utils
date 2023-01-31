package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;

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
    @CsvBindByName(column = "Carrier Name & Tracking Number")
    private String carrierNameTrackingNumber;

    @CsvBindByName(column = "Condition")
    private String condition;

    @CsvBindByName(column = "Currency")
    private String currency;

    @CsvBindByName(column = "Exemption Opt-Out")
    private String exemptionOptOut;

    @CsvBindByName(column = "Item Subtotal")
    private float itemSubtotal;

    @CsvBindByName(column = "Item Subtotal Tax")
    private float itemSubtotalTax;

    @CsvBindByName(column = "Item Total")
    private float itemTotal;

    @CsvBindByName(column = "List Price Per Unit")
    private float listPricePerUnit;

    @Column(nullable = true)
    @CsvBindByName(column = "Order Status")
    private String orderStatus;

    @CsvBindByName(column = "Ordering Customer Email")
    private String orderingCustomerEmail;

    @CsvBindByName(column = "Payment Instrument Type")
    private String paymentInstrumentType;

    @Column(nullable = true)
    @CsvBindByName(column = "PO Line Number")
    private String poLineNumber;

    @CsvBindByName(column = "Purchase Price Per Unit")
    private float purchasePricePerUnit;

    @CsvBindByName(column = "Release Date")
    private LocalDate releaseDate;

    @CsvBindByName(column = "Shipment Date")
    private LocalDate shipmentDate;

    @Column(nullable = true)
    @CsvBindByName(column = "Shipping Address City")
    private String shippingAddressCity;

    @Column(nullable = true)
    @CsvBindByName(column = "Shipping Address Name")
    private String shippingAddressName;

    @Column(nullable = true)
    @CsvBindByName(column = "Shipping Address State")
    private String shippingAddressState;

    @Column(nullable = true)
    @CsvBindByName(column = "Shipping Address Street 1")
    private String shippingAddressStreet1;

    @Column(nullable = true)
    @CsvBindByName(column = "Shipping Address Street 2")
    private String shippingAddressStreet2;

    @Column(nullable = true)
    @CsvBindByName(column = "Shipping Address Zip")
    private String shippingAddressZip;

    @CsvBindByName(column = "UNSPSC Code")
    private String unspscCode;
}
