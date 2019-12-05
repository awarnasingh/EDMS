package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.Status;

public interface StatusService {
	
	  /**
     * Save a Status.
     *
     * @param Status the entity to save.
     * @return the persisted entity.
     */
    Status save(Status status);

    /**
     * Get all the Status.
     *
     * @return the list of entities.
     */
    List<Status> findAll();


    /**
     * Get the "id" Status.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Status> findOne(Long id);

    /**
     * Delete the "id" Status.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
