package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.EmpType;
import com.edms.core.domain.Employee;
import com.edms.core.domain.EndClient;

@SuppressWarnings("unused")
@Repository
public interface EndClientRepository extends JpaRepository<EndClient, Long>{

	@Query(value = "select * from edms.end_client where id = :ID", nativeQuery = true)
	EndClient findByID(@Param("ID") String ID);

}
