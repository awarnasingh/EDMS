package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.EmpType;
import com.edms.core.domain.Employee;
import com.edms.core.domain.Status;

@SuppressWarnings("unused")
@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

	@Query(value = "select * from edms.status where id = :ID", nativeQuery = true)
	Status findByID(@Param("ID") String ID);

}
