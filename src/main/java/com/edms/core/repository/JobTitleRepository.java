package com.edms.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edms.core.domain.Employee;
import com.edms.core.domain.JobTitle;

@SuppressWarnings("unused")
@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long>{

}
