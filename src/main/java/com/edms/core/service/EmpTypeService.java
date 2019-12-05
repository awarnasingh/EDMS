package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.EmpType;

public interface EmpTypeService {
	
	 /**
     * Save a EmpType.
     *
     * @param EmpType the entity to save.
     * @return the persisted entity.
     */
    EmpType save(EmpType empType);

    /**
     * Get all the EmpType.
     *
     * @return the list of entities.
     */
    List<EmpType> findAll();


    /**
     * Get the "id" EmpType.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EmpType> findOne(Long id);

    /**
     * Delete the "id" EmpType.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
