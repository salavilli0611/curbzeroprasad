package com.curbzero.rest.entity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curbzero.rest.entity.model.CurbZeroType;

public interface CurbZeroTypeRepository extends JpaRepository<CurbZeroType, Long> {
	CurbZeroType findByType(String type);
}
