package com.kickthedrawer.ynab.amazon.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kickthedrawer.ynab.amazon.persistence.model.Refund;

public interface RefundRepository extends CrudRepository<Refund, String> {
    
}
