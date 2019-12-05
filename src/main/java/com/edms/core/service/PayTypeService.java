package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.Mode;
import com.edms.core.domain.PayType;

public interface PayTypeService {
	
	  /**
     * Save a PayType.
     *
     * @param PayType the entity to save.
     * @return the persisted entity.
     */
    PayType save(PayType payType);

    /**
     * Get all the PayType.
     *
     * @return the list of entities.
     */
    List<PayType> findAll();


    /**
     * Get the "id" PayType.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PayType> findOne(Long id);

    /**
     * Delete the "id" PayType.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
