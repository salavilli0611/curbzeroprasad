package com.curbzero.rest.entity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curbzero.rest.entity.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByName(String id);
}
