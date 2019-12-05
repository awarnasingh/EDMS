package com.edms.core.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edms.core.constants.ConstantUtils;
import com.edms.core.domain.Location;
import com.edms.core.service.LocationService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class LocationResource {
	
	private final Logger log = LoggerFactory.getLogger(LocationResource.class);

    private static final String ENTITY_NAME = "Location";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private LocationService  locationService;

    /**
     * {@code POST  /locations} : Create a new Location.
     *
     * @param Location the Location to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new Location, or with status {@code 400 (Bad Request)} if the Location has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@Valid @RequestBody Location location) throws URISyntaxException {
        log.debug("REST request to save Location : {}", location);
        if (location.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.LOCATION_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        Location result = locationService .save(location);
        return ResponseEntity.created(new URI(ConstantUtils.API_LOCATIONS + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /locations} : Updates an existing Location.
     *
     * @param Location the Location to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated Location,
     * or with status {@code 400 (Bad Request)} if the Location is not valid,
     * or with status {@code 500 (Internal Server Error)} if the Location couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/locations")
    public ResponseEntity<Location> updateLocation(@Valid @RequestBody Location location) throws URISyntaxException {
        log.debug("REST request to update Location : {}", location);
        if (location.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        Location result = locationService .save(location);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, location.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /locations} : get all the Locations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of Locations in body.
     */
    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        log.debug("REST request to get all Locations");
        return locationService .findAll();
    }

    /**
     * {@code GET  /locations/:id} : get the "id" Location.
     *
     * @param id the id of the Location to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the Location, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        log.debug("REST request to get Location : {}", id);
        Optional<Location> Location = locationService .findOne(id);
        return ResponseUtil.wrapOrNotFound(Location);
    }

    /**
     * {@code DELETE  /locations/:id} : delete the "id" Location.
     *
     * @param id the id of the Location to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        log.debug("REST request to delete Location : {}", id);
        locationService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
