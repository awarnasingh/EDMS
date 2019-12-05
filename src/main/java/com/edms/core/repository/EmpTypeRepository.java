package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.EmpType;


@Repository
public interface EmpTypeRepository extends JpaRepository<EmpType, Long>{
	@Query(value = "select * from edms.emp_type where id = :ID", nativeQuery = true)
	EmpType findByID(@Param("ID") String ID);

}
