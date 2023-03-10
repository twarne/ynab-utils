package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import com.kickthedrawer.ynab.amazon.helper.AmountConverter;
import com.kickthedrawer.ynab.amazon.helper.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "orders", uniqueConstraints = { @UniqueConstraint(columnNames = { "orderId", "unspscCode" }) })
public class Order extends LineItem {
    @Column(nullable = true)
    @CsvBindByName(column = "Carrier Name & Tracking Number")
    private String carrierNameTrackingNumber;

    @CsvBindByName(column = "Condition")
    private String condition;

    @CsvBindByName(column = "Currency")
    private String currency;

    @CsvBindByName(column = "Exemption Opt-Out")
    private String exemptionOptOut;

    @CsvCustomBindByName(column = "Item Subtotal", converter = AmountConverter.class)
    private float itemSubtotal;

    @CsvCustomBindByName(column = "Item Subtotal Tax", converter = AmountConverter.class)
    private float itemSubtotalTax;

    @CsvCustomBindByName(column = "Item Total", converter = AmountConverter.class)
    private float itemTotal;

    @CsvCustomBindByName(column = "List Price Per Unit", converter = AmountConverter.class)
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

    @CsvCustomBindByName(column = "Purchase Price Per Unit", converter = AmountConverter.class)
    private float purchasePricePerUnit;

    @CsvCustomBindByName(column = "Release Date", converter = LocalDateConverter.class)
    private LocalDate releaseDate;

    @CsvCustomBindByName(column = "Shipment Date", converter = LocalDateConverter.class)
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
