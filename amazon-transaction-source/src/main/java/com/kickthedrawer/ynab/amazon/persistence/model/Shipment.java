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
@Table(name = "shipments", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "orderId", "carrierNameTrackingNumber" }) })
public class Shipment extends ReportItem {


    @CsvBindByName(column = "Carrier Name & Tracking Number")
    private String carrierNameTrackingNumber;

    @CsvBindByName(column = "Order Status")
    private String orderStatus;

    @CsvBindByName(column = "Ordering Customer Email")
    private String orderingCustomerEmail;

    @CsvBindByName(column = "Payment Instrument Type")
    private String paymentInstrumentType;

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

    @CsvCustomBindByName(column = "Shipping Charge", converter = AmountConverter.class)
    private float shippingCharge;

    @CsvCustomBindByName(column = "Subtotal", converter = AmountConverter.class)
    private float subtotal;

    @CsvCustomBindByName(column = "Tax Before Promotion", converter = AmountConverter.class)
    private float taxBeforePromotions;

    @CsvCustomBindByName(column = "Tax Charged", converter = AmountConverter.class)
    private float taxCharged;

    @CsvCustomBindByName(column = "Total Charged", converter = AmountConverter.class)
    private float totalCharged;

    @CsvCustomBindByName(column = "Total Promotions", converter = AmountConverter.class)
    private float totalPromotions;

}
