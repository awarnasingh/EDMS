package com.edms.core.service;

import com.edms.core.domain.Professional;
import com.edms.core.web.rest.vm.SearchVm;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Professional}.
 */
public interface ProfessionalService {

    /**
     * Save a professional.
     *
     * @param professional the entity to save.
     * @return the persisted entity.
     */
    Professional save(Professional professional);

    /**
     * Get all the professionals.
     *
     * @return the list of entities.
     */
    List<Professional> findAll();


    /**
     * Get the "id" professional.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Professional> findOne(Long id);

    /**
     * Delete the "id" professional.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    List<Professional> searchAll(SearchVm searchVm);
}
