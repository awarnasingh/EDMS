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
import com.edms.core.domain.WorkAuthorization;
import com.edms.core.service.WorkAuthorizationService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class WorkAuthorizationResource {
	
	private final Logger log = LoggerFactory.getLogger(WorkAuthorizationResource.class);

    private static final String ENTITY_NAME = "WorkAuthorization";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private WorkAuthorizationService  authorizationService;

    /**
     * {@code POST  /workAuthorizations} : Create a new WorkAuthorization.
     *
     * @param WorkAuthorization the WorkAuthorization to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new WorkAuthorization, or with status {@code 400 (Bad Request)} if the WorkAuthorization has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/workAuthorizations")
    public ResponseEntity<WorkAuthorization> createWorkAuthorization(@Valid @RequestBody WorkAuthorization workAuthorization) throws URISyntaxException {
        log.debug("REST request to save WorkAuthorization : {}", workAuthorization);
        if (workAuthorization.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.WORK_AUTHORIZATION_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        WorkAuthorization result = authorizationService .save(workAuthorization);
        return ResponseEntity.created(new URI(ConstantUtils.API_WORKAUTHORIZATIONS + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /workAuthorizations} : Updates an existing WorkAuthorization.
     *
     * @param WorkAuthorization the WorkAuthorization to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated WorkAuthorization,
     * or with status {@code 400 (Bad Request)} if the WorkAuthorization is not valid,
     * or with status {@code 500 (Internal Server Error)} if the WorkAuthorization couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/workAuthorizations")
    public ResponseEntity<WorkAuthorization> updateWorkAuthorization(@Valid @RequestBody WorkAuthorization workAuthorization) throws URISyntaxException {
        log.debug("REST request to update WorkAuthorization : {}", workAuthorization);
        if (workAuthorization.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        WorkAuthorization result = authorizationService .save(workAuthorization);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workAuthorization.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /workAuthorizations} : get all the WorkAuthorizations.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of WorkAuthorizations in body.
     */
    @GetMapping("/workAuthorizations")
    public List<WorkAuthorization> getAllWorkAuthorizations() {
        log.debug("REST request to get all WorkAuthorizations");
        return authorizationService .findAll();
    }

    /**
     * {@code GET  /workAuthorizations/:id} : get the "id" WorkAuthorization.
     *
     * @param id the id of the WorkAuthorization to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the WorkAuthorization, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/workAuthorizations/{id}")
    public ResponseEntity<WorkAuthorization> getWorkAuthorization(@PathVariable Long id) {
        log.debug("REST request to get WorkAuthorization : {}", id);
        Optional<WorkAuthorization> workAuthorization = authorizationService .findOne(id);
        return ResponseUtil.wrapOrNotFound(workAuthorization);
    }

    /**
     * {@code DELETE  /workAuthorizations/:id} : delete the "id" WorkAuthorization.
     *
     * @param id the id of the WorkAuthorization to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/workAuthorizations/{id}")
    public ResponseEntity<Void> deleteWorkAuthorization(@PathVariable Long id) {
        log.debug("REST request to delete WorkAuthorization : {}", id);
        authorizationService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
