package com.kickthedrawer.ynab.amazon.persistence.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kickthedrawer.ynab.amazon.persistence.model.Refund;

public interface RefundRepository extends CrudRepository<Refund, String> {

    List<Refund> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
    
}
