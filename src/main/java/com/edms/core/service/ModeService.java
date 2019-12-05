package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.Location;
import com.edms.core.domain.Mode;

public interface ModeService {
	
	  /**
     * Save a Mode.
     *
     * @param Mode the entity to save.
     * @return the persisted entity.
     */
    Mode save(Mode mode);

    /**
     * Get all the Mode.
     *
     * @return the list of entities.
     */
    List<Mode> findAll();


    /**
     * Get the "id" Mode.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Mode> findOne(Long id);

    /**
     * Delete the "id" Mode.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
