package com.curbzero.rest.entity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curbzero.rest.entity.model.StoreCustomer;

public interface StoreCustomerRepository extends JpaRepository<StoreCustomer, Long> {
	StoreCustomer findByStoreOrderId(String storeOrderId);
}
