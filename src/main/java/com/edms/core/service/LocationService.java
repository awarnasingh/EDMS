package com.edms.core.service;

import java.util.List;
import java.util.Optional;

import com.edms.core.domain.JobTitle;
import com.edms.core.domain.Location;

public interface LocationService {
	
	  /**
     * Save a Location.
     *
     * @param Location the entity to save.
     * @return the persisted entity.
     */
    Location save(Location location);

    /**
     * Get all the Location.
     *
     * @return the list of entities.
     */
    List<Location> findAll();


    /**
     * Get the "id" Location.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Location> findOne(Long id);

    /**
     * Delete the "id" JobTitle.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
