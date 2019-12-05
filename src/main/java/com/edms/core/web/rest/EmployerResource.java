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
import com.edms.core.domain.Employer;
import com.edms.core.service.EmployerService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class EmployerResource {
	
	private final Logger log = LoggerFactory.getLogger(EmployerResource.class);

    private static final String ENTITY_NAME = "Employer";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private EmployerService employerService;

    /**
     * {@code POST  /employers} : Create a new Employer.
     *
     * @param Employer the Employer to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new Employer, or with status {@code 400 (Bad Request)} if the Employer has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/employers")
    public ResponseEntity<Employer> createEmployer(@Valid @RequestBody Employer employer) throws URISyntaxException {
        log.debug("REST request to save Employer : {}", employer);
        if (employer.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.EMPLOYER_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        Employer result = employerService .save(employer);
        return ResponseEntity.created(new URI(ConstantUtils.API_EMPLOYERS + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /employers} : Updates an existing Employer.
     *
     * @param Employer the Employer to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated Employer,
     * or with status {@code 400 (Bad Request)} if the Employer is not valid,
     * or with status {@code 500 (Internal Server Error)} if the Employer couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/employers")
    public ResponseEntity<Employer> updateEmployer(@Valid @RequestBody Employer employer) throws URISyntaxException {
        log.debug("REST request to update Employer : {}", employer);
        if (employer.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        Employer result = employerService .save(employer);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, employer.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /employers} : get all the Employers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of Employers in body.
     */
    @GetMapping("/employers")
    public List<Employer> getAllEmployers() {
        log.debug("REST request to get all Employers");
        return employerService .findAll();
    }

    /**
     * {@code GET  /employers/:id} : get the "id" Employer.
     *
     * @param id the id of the Employer to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the Employer, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/employers/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable Long id) {
        log.debug("REST request to get Employer : {}", id);
        Optional<Employer> employer = employerService .findOne(id);
        return ResponseUtil.wrapOrNotFound(employer);
    }

    /**
     * {@code DELETE  /employers/:id} : delete the "id" Employer.
     *
     * @param id the id of the Employer to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/employers/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        log.debug("REST request to delete Employer : {}", id);
        employerService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
