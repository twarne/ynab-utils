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
@Table(name="shipments")
public class Shipment extends ReportItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String carrierNameTrackingNumber;

    private String orderStatus;

    private String orderingCustomerEmail;

    private String paymentInstrumentType;

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

    private float shippingCharge;

    private float subtotal;

    private float taxBeforePromotions;

    private float taxCharged;

    private float totalCharged;

    private float totalPromotions;

}
