package com.kickthedrawer.ynab.amazon.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kickthedrawer.ynab.amazon.persistence.model.Shipment;

public interface ShipmentRepository extends CrudRepository<Shipment, String> {
    
}
