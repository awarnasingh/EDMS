package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.Employee;
import com.edms.core.domain.PayType;

@SuppressWarnings("unused")
@Repository
public interface PayTypeRepository extends JpaRepository<PayType, Long>{

}
