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
import com.edms.core.domain.PayType;
import com.edms.core.service.PayTypeService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class PayTypeResource {
	
	private final Logger log = LoggerFactory.getLogger(PayTypeResource.class);

    private static final String ENTITY_NAME = "PayType";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private PayTypeService  payTypeService;

    /**
     * {@code POST  /paytypes} : Create a new PayType.
     *
     * @param PayType the PayType to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new PayType, or with status {@code 400 (Bad Request)} if the PayType has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/paytypes")
    public ResponseEntity<PayType> createPayType(@Valid @RequestBody PayType payType) throws URISyntaxException {
        log.debug("REST request to save PayType : {}", payType);
        if (payType.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.PAYTYPE_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        PayType result = payTypeService .save(payType);
        return ResponseEntity.created(new URI("/api/paytypes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /paytypes} : Updates an existing PayType.
     *
     * @param PayType the PayType to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated PayType,
     * or with status {@code 400 (Bad Request)} if the PayType is not valid,
     * or with status {@code 500 (Internal Server Error)} if the PayType couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/paytypes")
    public ResponseEntity<PayType> updatePayType(@Valid @RequestBody PayType payType) throws URISyntaxException {
        log.debug("REST request to update PayType : {}", payType);
        if (payType.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PayType result = payTypeService .save(payType);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, payType.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /paytypes} : get all the PayTypes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of PayTypes in body.
     */
    @GetMapping("/paytypes")
    public List<PayType> getAllPayTypes() {
        log.debug("REST request to get all PayTypes");
        return payTypeService .findAll();
    }

    /**
     * {@code GET  /paytypes/:id} : get the "id" PayType.
     *
     * @param id the id of the PayType to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the PayType, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/paytypes/{id}")
    public ResponseEntity<PayType> getPayType(@PathVariable Long id) {
        log.debug("REST request to get PayType : {}", id);
        Optional<PayType> payType = payTypeService .findOne(id);
        return ResponseUtil.wrapOrNotFound(payType);
    }

    /**
     * {@code DELETE  /paytypes/:id} : delete the "id" PayType.
     *
     * @param id the id of the PayType to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/paytypes/{id}")
    public ResponseEntity<Void> deletePayType(@PathVariable Long id) {
        log.debug("REST request to delete PayType : {}", id);
        payTypeService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
