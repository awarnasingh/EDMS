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
import com.edms.core.domain.ClientDomain;
import com.edms.core.service.ClientDomainService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class ClientDomainResource {
	
	private final Logger log = LoggerFactory.getLogger(ClientDomainResource.class);

    private static final String ENTITY_NAME = "ClientDomain";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired(required=true)
    private ClientDomainService clientDomainService;

    /**
     * {@code POST  /clientDomains} : Create a new ClientDomain.
     *
     * @param ClientDomain the ClientDomain to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ClientDomain, or with status {@code 400 (Bad Request)} if the ClientDomain has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clientDomains")
    public ResponseEntity<ClientDomain> createClientDomain(@Valid @RequestBody ClientDomain clientDomain) throws URISyntaxException {
        log.debug("REST request to save ClientDomain : {}", clientDomain);
        if (clientDomain.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.CLIENT_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        ClientDomain result = clientDomainService .save(clientDomain);
        return ResponseEntity.created(new URI("/api/clientDomains/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /clientDomains} : Updates an existing ClientDomain.
     *
     * @param ClientDomain the ClientDomain to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ClientDomain,
     * or with status {@code 400 (Bad Request)} if the ClientDomain is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ClientDomain couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/clientDomains")
    public ResponseEntity<ClientDomain> updateClientDomain(@Valid @RequestBody ClientDomain clientDomain) throws URISyntaxException {
        log.debug("REST request to update ClientDomain : {}", clientDomain);
        if (clientDomain.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME,ConstantUtils.ID_NULL );
        }
        ClientDomain result = clientDomainService .save(clientDomain);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, clientDomain.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /clientDomains} : get all the ClientDomains.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ClientDomains in body.
     */
    @GetMapping("/clientDomains")
    public List<ClientDomain> getAllClientDomains() {
        log.debug("REST request to get all ClientDomains");
        return clientDomainService .findAll();
    }

    /**
     * {@code GET  /clientDomains/:id} : get the "id" ClientDomain.
     *
     * @param id the id of the ClientDomain to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ClientDomain, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/clientDomains/{id}")
    public ResponseEntity<ClientDomain> getClientDomain(@PathVariable Long id) {
        log.debug("REST request to get ClientDomain : {}", id);
        Optional<ClientDomain> clientDomain = clientDomainService .findOne(id);
        return ResponseUtil.wrapOrNotFound(clientDomain);
    }

    /**
     * {@code DELETE  /clientDomains/:id} : delete the "id" ClientDomain.
     *
     * @param id the id of the ClientDomain to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/clientDomains/{id}")
    public ResponseEntity<Void> deleteClientDomain(@PathVariable Long id) {
        log.debug("REST request to delete ClientDomain : {}", id);
        clientDomainService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
