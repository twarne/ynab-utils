package com.kickthedrawer.ynab.amazon.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kickthedrawer.ynab.amazon.persistence.model.Order;

public interface OrderRepository extends CrudRepository<Order, String> {
    
}
