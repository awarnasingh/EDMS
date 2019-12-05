package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.ClientDomain;
import com.edms.core.domain.Employer;

public interface EmployerService {
	
	 /**
     * Save a Employer.
     *
     * @param Employer the entity to save.
     * @return the persisted entity.
     */
    Employer save(Employer employer);

    /**
     * Get all the Employer.
     *
     * @return the list of entities.
     */
    List<Employer> findAll();


    /**
     * Get the "id" Employer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Employer> findOne(Long id);

    /**
     * Delete the "id" Employer.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
