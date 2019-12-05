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
import com.edms.core.domain.PrimeVendor;
import com.edms.core.service.PrimeVendorService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class PrimeVendorResource {
	
	private final Logger log = LoggerFactory.getLogger(PrimeVendorResource.class);

    private static final String ENTITY_NAME = "PrimeVendor";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private PrimeVendorService  primeVendorService;

    /**
     * {@code POST  /endClients} : Create a new primeVendor.
     *
     * @param PrimeVendor the primeVendor to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new PrimeVendor, or with status {@code 400 (Bad Request)} if the EndClient has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/primeVendor")
    public ResponseEntity<PrimeVendor> createPrimeVendor(@Valid @RequestBody PrimeVendor primeVendor) throws URISyntaxException {
        log.debug("REST request to save PrimeVendor : {}", primeVendor);
        if (primeVendor.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.PRIMEVENDOR_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        PrimeVendor result = primeVendorService .save(primeVendor);
        return ResponseEntity.created(new URI(ConstantUtils.API_PRIMEVENDOR + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /primeVendor} : Updates an existing PrimeVendor.
     *
     * @param PrimeVendor the PrimeVendor to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated PrimeVendor,
     * or with status {@code 400 (Bad Request)} if the PrimeVendor is not valid,
     * or with status {@code 500 (Internal Server Error)} if the PrimeVendor couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/primeVendor")
    public ResponseEntity<PrimeVendor> updatePrimeVendor(@Valid @RequestBody PrimeVendor primeVendor) throws URISyntaxException {
        log.debug("REST request to update PrimeVendor : {}", primeVendor);
        if (primeVendor.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        PrimeVendor result = primeVendorService .save(primeVendor);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, primeVendor.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /primeVendor} : get all the PrimeVendor.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of PrimeVendors in body.
     */
    @GetMapping("/primeVendor")
    public List<PrimeVendor> getAllPrimeVendors() {
        log.debug("REST request to get all PrimeVendors");
        return primeVendorService .findAll();
    }

    /**
     * {@code GET  /primeVendor/:id} : get the "id" PrimeVendor.
     *
     * @param id the id of the PrimeVendor to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the PrimeVendor, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/primeVendor/{id}")
    public ResponseEntity<PrimeVendor> getPrimeVendor(@PathVariable Long id) {
        log.debug("REST request to get PrimeVendor : {}", id);
        Optional<PrimeVendor> primeVendor = primeVendorService .findOne(id);
        return ResponseUtil.wrapOrNotFound(primeVendor);
    }

    /**
     * {@code DELETE  /primeVendor/:id} : delete the "id" PrimeVendor.
     *
     * @param id the id of the PrimeVendor to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/primeVendor/{id}")
    public ResponseEntity<Void> deletePrimeVendor(@PathVariable Long id) {
        log.debug("REST request to delete PrimeVendor : {}", id);
        primeVendorService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
