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
import com.edms.core.domain.EndClient;
import com.edms.core.service.EndClientService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class EndClientResource {
	
	private final Logger log = LoggerFactory.getLogger(EndClientResource.class);

    private static final String ENTITY_NAME = "EndClient";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private EndClientService  endClientService;

    /**
     * {@code POST  /endClients} : Create a new EndClient.
     *
     * @param EndClient the EndClient to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new EndClient, or with status {@code 400 (Bad Request)} if the EndClient has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/endClients")
    public ResponseEntity<EndClient> createEndClient(@Valid @RequestBody EndClient endClient) throws URISyntaxException {
        log.debug("REST request to save EndClient : {}", endClient);
        if (endClient.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.ENDCLIENT_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        EndClient result = endClientService .save(endClient);
        return ResponseEntity.created(new URI(ConstantUtils.API_ENDCLIENTS + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /endClients} : Updates an existing EndClient.
     *
     * @param EndClient the EndClient to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated EndClient,
     * or with status {@code 400 (Bad Request)} if the EndClient is not valid,
     * or with status {@code 500 (Internal Server Error)} if the EndClient couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/endClients")
    public ResponseEntity<EndClient> updateEndClient(@Valid @RequestBody EndClient endClient) throws URISyntaxException {
        log.debug("REST request to update EndClient : {}", endClient);
        if (endClient.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        EndClient result = endClientService .save(endClient);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, endClient.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /endClients} : get all the EndClients.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of EndClients in body.
     */
    @GetMapping("/endClients")
    public List<EndClient> getAllEndClients() {
        log.debug("REST request to get all EndClients");
        return endClientService .findAll();
    }

    /**
     * {@code GET  /endClients/:id} : get the "id" EndClient.
     *
     * @param id the id of the EndClient to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the EndClient, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/endClients/{id}")
    public ResponseEntity<EndClient> getEndClient(@PathVariable Long id) {
        log.debug("REST request to get EndClient : {}", id);
        Optional<EndClient> endClient = endClientService .findOne(id);
        return ResponseUtil.wrapOrNotFound(endClient);
    }

    /**
     * {@code DELETE  /endClients/:id} : delete the "id" EndClient.
     *
     * @param id the id of the EndClient to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/endClients/{id}")
    public ResponseEntity<Void> deleteEndClient(@PathVariable Long id) {
        log.debug("REST request to delete EndClient : {}", id);
        endClientService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
