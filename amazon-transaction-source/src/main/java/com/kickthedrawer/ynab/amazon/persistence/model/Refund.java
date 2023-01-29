package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

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
@Table(name = "refunds")
public class Refund extends LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private float refundAmount;
    private String refundCondition;
    private LocalDate refundDate;
    private String refundReason;
    private float refundTaxAmount;
}
