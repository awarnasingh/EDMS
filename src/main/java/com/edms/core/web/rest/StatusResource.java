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
import com.edms.core.domain.Status;
import com.edms.core.service.StatusService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class StatusResource {
	
	private final Logger log = LoggerFactory.getLogger(StatusResource.class);

    private static final String ENTITY_NAME = "Status";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private StatusService statusService;

    /**
     * {@code POST  /status} : Create a new Status.
     *
     * @param Status the Status to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new Status, or with status {@code 400 (Bad Request)} if the Status has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/status")
    public ResponseEntity<Status> createStatus(@Valid @RequestBody Status status) throws URISyntaxException {
        log.debug("REST request to save Status : {}", status);
        if (status.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.STATUS_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        Status result = statusService .save(status);
        return ResponseEntity.created(new URI(ConstantUtils.API_STATUS + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /status} : Updates an existing Status.
     *
     * @param Status the Status to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated Status,
     * or with status {@code 400 (Bad Request)} if the Status is not valid,
     * or with status {@code 500 (Internal Server Error)} if the Status couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/status")
    public ResponseEntity<Status> updateStatus(@Valid @RequestBody Status status) throws URISyntaxException {
        log.debug("REST request to update Status : {}", status);
        if (status.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        Status result = statusService .save(status);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, status.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /status} : get all the Statuss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of Statuss in body.
     */
    @GetMapping("/status")
    public List<Status> getAllStatuss() {
        log.debug("REST request to get all Statuss");
        return statusService .findAll();
    }

    /**
     * {@code GET  /status/:id} : get the "id" Status.
     *
     * @param id the id of the Status to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the Status, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/status/{id}")
    public ResponseEntity<Status> getStatus(@PathVariable Long id) {
        log.debug("REST request to get Status : {}", id);
        Optional<Status> status = statusService .findOne(id);
        return ResponseUtil.wrapOrNotFound(status);
    }

    /**
     * {@code DELETE  /status/:id} : delete the "id" Status.
     *
     * @param id the id of the Status to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/status/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        log.debug("REST request to delete Status : {}", id);
        statusService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
