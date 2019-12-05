package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.Employee;
import com.edms.core.domain.EndClient;

public interface EndClientService {
	
	  /**
     * Save a EndClient.
     *
     * @param EndClient the entity to save.
     * @return the persisted entity.
     */
    EndClient save(EndClient endClient);

    /**
     * Get all the EndClient.
     *
     * @return the list of entities.
     */
    List<EndClient> findAll();


    /**
     * Get the "id" EndClient.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EndClient> findOne(Long id);

    /**
     * Delete the "id" EndClient.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
