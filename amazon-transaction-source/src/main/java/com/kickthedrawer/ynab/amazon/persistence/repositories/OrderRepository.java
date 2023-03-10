package com.kickthedrawer.ynab.amazon.persistence.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kickthedrawer.ynab.amazon.persistence.model.Order;

public interface OrderRepository extends CrudRepository<Order, String> {

    List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
    
}
