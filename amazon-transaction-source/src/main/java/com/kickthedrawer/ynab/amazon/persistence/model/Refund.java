package com.kickthedrawer.ynab.amazon.persistence.model;

import java.time.LocalDate;

import com.kickthedrawer.ynab.amazon.helper.AmountConverter;
import com.kickthedrawer.ynab.amazon.helper.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

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
@Table(name = "refunds", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "orderId", "refundDate", "refundAmount" }) })
public class Refund extends LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @CsvCustomBindByName(column = "Refund Amount", converter=AmountConverter.class)
    private float refundAmount;
    @CsvBindByName(column = "Refund Condition")
    private String refundCondition;
    @CsvCustomBindByName(column = "Refund Date", converter = LocalDateConverter.class)
    private LocalDate refundDate;
    @CsvBindByName(column = "Refund Reason")
    private String refundReason;
    @CsvCustomBindByName(column = "Refund Tax Amount", converter=AmountConverter.class)
    private float refundTaxAmount;
}
