package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;

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

    @CsvBindByName(column = "Refund Amount")
    private float refundAmount;
    @CsvBindByName(column = "Refund Condition")
    private String refundCondition;
    @CsvBindByName(column = "Refund Date")
    private LocalDate refundDate;
    @CsvBindByName(column = "Refund Reason")
    private String refundReason;
    @CsvBindByName(column = "Refund Tax Amount")
    private float refundTaxAmount;
}
