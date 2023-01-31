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
@Table(name="shipments")
public class Shipment extends ReportItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @CsvBindByName(column = "Carrier Name & Tracking Number")
    private String carrierNameTrackingNumber;

    @CsvBindByName(column = "Order Status")
    private String orderStatus;

    @CsvBindByName(column = "Ordering Customer Email")
    private String orderingCustomerEmail;

    @CsvBindByName(column = "Payment Instrument Type")
    private String paymentInstrumentType;

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

    @CsvBindByName(column = "Shipping Charge")
    private float shippingCharge;

    @CsvBindByName(column = "Subtotal")
    private float subtotal;

    @CsvBindByName(column = "Tax Before Promotion")
    private float taxBeforePromotions;

    @CsvBindByName(column = "Tax Charged")
    private float taxCharged;

    @CsvBindByName(column = "Total Charged")
    private float totalCharged;

    @CsvBindByName(column = "Total Promotions")
    private float totalPromotions;

}
