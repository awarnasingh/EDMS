package com.edms.core.web.rest;

import com.edms.core.constants.ConstantUtils;
import com.edms.core.domain.Professional;
import com.edms.core.service.ProfessionalService;
import com.edms.core.web.rest.errors.BadRequestAlertException;
import com.edms.core.web.rest.vm.SearchVm;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.edms.core.domain.Professional}.
 */

/**
 * @author anurag
 */
@RestController
@RequestMapping("/api")
public class ProfessionalResource {

    private final Logger log = LoggerFactory.getLogger(ProfessionalResource.class);

    private static final String ENTITY_NAME = "professional";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProfessionalService professionalService;

    public ProfessionalResource(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    /**
     * {@code POST  /professionals} : Create a new professional.
     *
     * @param professional the professional to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new professional, or with status {@code 400 (Bad Request)} if the professional has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/professionals")
    public ResponseEntity<Professional> createProfessional(@Valid @RequestBody Professional professional) throws URISyntaxException {
        log.debug("REST request to save Professional : {}", professional);
        if (professional.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.PROFESSIONAL_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        Professional result = professionalService.save(professional);
        return ResponseEntity.created(new URI(ConstantUtils.API_PROFESSIONAL + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code PUT  /professionals} : Updates an existing professional.
     *
     * @param professional the professional to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated professional,
     * or with status {@code 400 (Bad Request)} if the professional is not valid,
     * or with status {@code 500 (Internal Server Error)} if the professional couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/professionals")
    public ResponseEntity<Professional> updateProfessional(@Valid @RequestBody Professional professional) throws URISyntaxException {
        log.debug("REST request to update Professional : {}", professional);
        if (professional.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        Professional result = professionalService.save(professional);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, professional.getId().toString()))
                .body(result);
    }

    /**
     * {@code GET  /professionals} : get all the professionals.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of professionals in body.
     */
    @GetMapping("/professionals")
    public List<Professional> getAllProfessionals() {
        log.debug("REST request to get all Professionals");
        return professionalService.findAll();
    }

    /**
     * {@code GET  /professionals/:id} : get the "id" professional.
     *
     * @param id the id of the professional to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the professional, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/professionals/{id}")
    public ResponseEntity<Professional> getProfessional(@PathVariable Long id) {
        log.debug("REST request to get Professional : {}", id);
        return ResponseUtil.wrapOrNotFound(professionalService.findOne(id));
    }

    /**
     * {@code DELETE  /professionals/:id} : delete the "id" professional.
     *
     * @param id the id of the professional to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/professionals/{id}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable Long id) {
        log.debug("REST request to delete Professional : {}", id);
        professionalService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }


    /**
     * @param searchVm
     * @returns List of profeesional
     */
    @PostMapping("/search")
    public List<Professional> searchEmployee(@RequestBody SearchVm searchVm) {
        log.debug("REST request to search employees based on " + searchVm);
        return professionalService.searchAll(searchVm);
    }
}
