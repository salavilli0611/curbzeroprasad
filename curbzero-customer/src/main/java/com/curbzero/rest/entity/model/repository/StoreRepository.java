package com.curbzero.rest.entity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curbzero.rest.entity.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
	Store findByName(String name);
}
