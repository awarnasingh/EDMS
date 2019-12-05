package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.Employee;
import com.edms.core.domain.Mode;

/**
 * Spring Data  repository for the Mode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ModeRepository extends JpaRepository<Mode, Long>{

}
