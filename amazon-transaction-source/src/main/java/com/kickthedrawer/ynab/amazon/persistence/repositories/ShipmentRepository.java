package com.kickthedrawer.ynab.amazon.persistence.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kickthedrawer.ynab.amazon.persistence.model.Shipment;

public interface ShipmentRepository extends CrudRepository<Shipment, String> {

    List<Shipment> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
    
}
