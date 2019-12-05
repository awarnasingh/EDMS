package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.ClientDomain;

public interface ClientDomainService {
	
	 /**
     * Save a ClientDomain.
     *
     * @param ClientDomain the entity to save.
     * @return the persisted entity.
     */
    ClientDomain save(ClientDomain clientDomain);

    /**
     * Get all the ClientDomain.
     *
     * @return the list of entities.
     */
    List<ClientDomain> findAll();


    /**
     * Get the "id" ClientDomain.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ClientDomain> findOne(Long id);

    /**
     * Delete the "id" ClientDomain.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
