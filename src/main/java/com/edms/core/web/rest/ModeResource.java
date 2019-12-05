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
import com.edms.core.domain.Mode;
import com.edms.core.service.ModeService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class ModeResource {
	
	private final Logger log = LoggerFactory.getLogger(ModeResource.class);

    private static final String ENTITY_NAME = "Mode";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private ModeService  modeService;

    /**
     * {@code POST  /modes} : Create a new Mode.
     *
     * @param Mode the Mode to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new Mode, or with status {@code 400 (Bad Request)} if the Mode has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/modes")
    public ResponseEntity<Mode> createMode(@Valid @RequestBody Mode mode) throws URISyntaxException {
        log.debug("REST request to save Mode : {}", mode);
        if (mode.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.MODE_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        Mode result = modeService .save(mode);
        return ResponseEntity.created(new URI(ConstantUtils.API_MODES + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /modes} : Updates an existing Mode.
     *
     * @param Mode the Mode to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated Mode,
     * or with status {@code 400 (Bad Request)} if the Mode is not valid,
     * or with status {@code 500 (Internal Server Error)} if the Mode couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/modes")
    public ResponseEntity<Mode> updateMode(@Valid @RequestBody Mode mode) throws URISyntaxException {
        log.debug("REST request to update Mode : {}", mode);
        if (mode.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        Mode result = modeService .save(mode);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, mode.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /modes} : get all the Modes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of Modes in body.
     */
    @GetMapping("/modes")
    public List<Mode> getAllModes() {
        log.debug("REST request to get all Modes");
        return modeService .findAll();
    }

    /**
     * {@code GET  /modes/:id} : get the "id" Mode.
     *
     * @param id the id of the Mode to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the Mode, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/modes/{id}")
    public ResponseEntity<Mode> getMode(@PathVariable Long id) {
        log.debug("REST request to get Mode : {}", id);
        Optional<Mode> mode = modeService .findOne(id);
        return ResponseUtil.wrapOrNotFound(mode);
    }

    /**
     * {@code DELETE  /modes/:id} : delete the "id" Mode.
     *
     * @param id the id of the Mode to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/modes/{id}")
    public ResponseEntity<Void> deleteMode(@PathVariable Long id) {
        log.debug("REST request to delete Mode : {}", id);
        modeService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
