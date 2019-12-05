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
import com.edms.core.domain.EmpType;
import com.edms.core.service.EmpTypeService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class EmpTypeResource {
	
	private final Logger log = LoggerFactory.getLogger(EmpTypeResource.class);

    private static final String ENTITY_NAME = "EmpType";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private EmpTypeService empTypeService;

    /**
     * {@code POST  /empTypes} : Create a new EmpType.
     *
     * @param EmpType the EmpType to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new EmpType, or with status {@code 400 (Bad Request)} if the EmpType has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/empTypes")
    public ResponseEntity<EmpType> createEmpType(@Valid @RequestBody EmpType empType) throws URISyntaxException {
        log.debug("REST request to save EmpType : {}", empType);
        if (empType.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.EMPTYPE_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        EmpType result = empTypeService .save(empType);
        return ResponseEntity.created(new URI(ConstantUtils.API_EMPTYPES + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /empTypes} : Updates an existing EmpType.
     *
     * @param EmpType the EmpType to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated EmpType,
     * or with status {@code 400 (Bad Request)} if the EmpType is not valid,
     * or with status {@code 500 (Internal Server Error)} if the EmpType couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/empTypes")
    public ResponseEntity<EmpType> updateEmpType(@Valid @RequestBody EmpType empType) throws URISyntaxException {
        log.debug("REST request to update EmpType : {}", empType);
        if (empType.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        EmpType result = empTypeService .save(empType);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, empType.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /empTypes} : get all the EmpTypes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of EmpTypes in body.
     */
    @GetMapping("/empTypes")
    public List<EmpType> getAllEmpTypes() {
        log.debug("REST request to get all EmpTypes");
        return empTypeService .findAll();
    }

    /**
     * {@code GET  /empTypes/:id} : get the "id" EmpType.
     *
     * @param id the id of the EmpType to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the EmpType, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/empTypes/{id}")
    public ResponseEntity<EmpType> getEmpType(@PathVariable Long id) {
        log.debug("REST request to get EmpType : {}", id);
        Optional<EmpType> empType = empTypeService .findOne(id);
        return ResponseUtil.wrapOrNotFound(empType);
    }

    /**
     * {@code DELETE  /empTypes/:id} : delete the "id" EmpType.
     *
     * @param id the id of the EmpType to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/empTypes/{id}")
    public ResponseEntity<Void> deleteEmpType(@PathVariable Long id) {
        log.debug("REST request to delete EmpType : {}", id);
        empTypeService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
