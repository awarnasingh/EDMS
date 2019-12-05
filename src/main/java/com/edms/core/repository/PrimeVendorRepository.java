package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.PrimeVendor;

@Repository
public interface PrimeVendorRepository extends JpaRepository<PrimeVendor, Long>{

}

