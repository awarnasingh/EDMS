package com.edms.core.repository;

import com.edms.core.domain.Professional;
import com.edms.core.domain.ProfessionalHistory;
import com.edms.core.domain.SearchHistory;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProfessionalHistory entity.
 */
@Repository
public interface ProfessionalHistoryRepository extends JpaRepository<ProfessionalHistory, Long> {

	@Query(value = "select * from edms.professional_history where professional_id = :id", nativeQuery = true)
	List<ProfessionalHistory> getProfessionalHistoryByPid(@Param("id") Long id);

	
}
