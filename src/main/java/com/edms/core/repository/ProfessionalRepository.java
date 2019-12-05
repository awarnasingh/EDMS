package com.edms.core.repository;

import com.edms.core.domain.DropDownValue;
import com.edms.core.domain.Professional;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Professional entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
	
	
	
	 /**
	 * this method fetchs the distinct values for the given parameters 
	 * and returns the list of DropDownValue
	 */
	@Query(value = "SELECT DISTINCT location,client_domain as clientDomain,end_client as endClient,status,jhi_mode as mode, employer,prime_vendor as primeVendor,emp_type as empType FROM  edms.professional,edms.employee",nativeQuery = true)
     List<DropDownValue> searchDropdown();
	
	 /**
	 * @param location
	 * @param expStart
	 * @param expEnd
	 * @param domain
	 * @param type
	 * @param status
	 * @param endClient
	 * @param skills
	 * @param fullName
	 * @returns List of {@link Professional}
	 * 
	 * this method search the professional employee based on same creteria 
	 */
	@Query(value = "call search(:loc,:expStart,:expEnd,:domain,:empType,:stat,:skills,:endClient,:name)", nativeQuery = true)
		List<Professional> searchAll(@Param("loc") String location,@Param("expStart") Double expStart,@Param("expEnd") Double expEnd,
				@Param("domain") String domain,
				@Param("empType") String type,@Param("stat") String status,@Param("endClient") String endClient,@Param("skills") String skills,@Param("name") String fullName);
}
