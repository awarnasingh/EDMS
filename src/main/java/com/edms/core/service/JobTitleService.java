package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.Employee;
import com.edms.core.domain.JobTitle;

public interface JobTitleService {
	
	  /**
     * Save a JobTitle.
     *
     * @param JobTitle the entity to save.
     * @return the persisted entity.
     */
    JobTitle save(JobTitle jobTitle);

    /**
     * Get all the JobTitle.
     *
     * @return the list of entities.
     */
    List<JobTitle> findAll();


    /**
     * Get the "id" JobTitle.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<JobTitle> findOne(Long id);

    /**
     * Delete the "id" JobTitle.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
