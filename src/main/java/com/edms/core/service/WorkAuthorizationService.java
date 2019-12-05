package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.WorkAuthorization;

public interface WorkAuthorizationService {
	
	  /**
     * Save a WorkAuthorization.
     *
     * @param WorkAuthorization the entity to save.
     * @return the persisted entity.
     */
    WorkAuthorization save(WorkAuthorization workAuthorization);

    /**
     * Get all the WorkAuthorization.
     *
     * @return the list of entities.
     */
    List<WorkAuthorization> findAll();


    /**
     * Get the "id" WorkAuthorization.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WorkAuthorization> findOne(Long id);

    /**
     * Delete the "id" WorkAuthorization.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
