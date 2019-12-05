package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.EmpType;
import com.edms.core.domain.Employee;
import com.edms.core.domain.Location;

@SuppressWarnings("unused")
@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

	@Query(value = "select * from edms.location where id = :ID", nativeQuery = true)
	Location findByID(@Param("ID") String ID);

}
