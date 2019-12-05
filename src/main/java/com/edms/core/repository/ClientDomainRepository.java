package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.ClientDomain;
import com.edms.core.domain.EmpType;
import com.edms.core.domain.Employee;

@SuppressWarnings("unused")
@Repository
public interface ClientDomainRepository extends JpaRepository<ClientDomain, Long>{

	@Query(value = "select * from edms.client_domain where id = :ID", nativeQuery = true)
	ClientDomain findByID(@Param("ID") String ID);

}
