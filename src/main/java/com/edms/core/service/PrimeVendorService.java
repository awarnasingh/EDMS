package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.PrimeVendor;

public interface PrimeVendorService {
	
	  /**
     * Save a PrimeVendor.
     *
     * @param PrimeVendor the entity to save.
     * @return the persisted entity.
     */
    PrimeVendor save(PrimeVendor primeVendor);

    /**
     * Get all the PrimeVendor.
     *
     * @return the list of entities.
     */
    List<PrimeVendor> findAll();


    /**
     * Get the "id" PrimeVendor.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PrimeVendor> findOne(Long id);

    /**
     * Delete the "id" PrimeVendor.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
