package com.edms.core.web.rest;

import com.edms.core.constants.ConstantUtils;
import com.edms.core.domain.ProfessionalHistory;
import com.edms.core.repository.ProfessionalHistoryRepository;
import com.edms.core.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing {@link com.edms.core.domain.ProfessionalHistory}.
 */
@RestController
@RequestMapping("/api")
public class ProfessionalHistoryResource {

    private final Logger log = LoggerFactory.getLogger(ProfessionalHistoryResource.class);

    private static final String ENTITY_NAME = ProfessionalHistoryResource.class.getSimpleName();

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private ProfessionalHistoryRepository professionalHistoryRepository;

    /**
     * {@code POST  /professional-histories} : Create a new professionalHistory.
     *
     * @param professionalHistory the professionalHistory to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new professionalHistory, or with status {@code 400 (Bad Request)} if the professionalHistory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/professional-histories")
    public ResponseEntity<ProfessionalHistory> createProfessionalHistory(@RequestBody ProfessionalHistory professionalHistory) throws URISyntaxException {
        log.debug("REST request to save ProfessionalHistory : {}", professionalHistory);
        if (professionalHistory.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.PROFESSIONALHISTORY_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }

        ProfessionalHistory result = professionalHistoryRepository.save(professionalHistory);
        return ResponseEntity.created(new URI(ConstantUtils.API_PROFESSIONAL_HISTORIES + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code PUT  /professional-histories} : Updates an existing professionalHistory.
     *
     * @param professionalHistory the professionalHistory to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated professionalHistory,
     * or with status {@code 400 (Bad Request)} if the professionalHistory is not valid,
     * or with status {@code 500 (Internal Server Error)} if the professionalHistory couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/professional-histories")
    public ResponseEntity<ProfessionalHistory> updateProfessionalHistory(@RequestBody ProfessionalHistory professionalHistory) throws URISyntaxException {
        log.debug("REST request to update ProfessionalHistory : {}", professionalHistory);
        if (professionalHistory.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        ProfessionalHistory result = professionalHistoryRepository.save(professionalHistory);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, professionalHistory.getId().toString()))
                .body(result);
    }

    /**
     * {@code GET  /professional-histories} : get all the professionalHistories.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of professionalHistories in body.
     */
    @GetMapping("/professional-histories")
    public List<ProfessionalHistory> getAllProfessionalHistories() {
        log.debug("REST request to get all ProfessionalHistories");
        return professionalHistoryRepository.findAll();
    }

    /**
     * {@code GET  /professionalhistoriesByPid/:id} : get the "id" professionalHistory.
     *
     * @param id the id of the professionalHistory to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the professionalHistory, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/professionalhistoriesByPid/{id}")
    public List<ProfessionalHistory> getProfessionalHistoryByPid(@PathVariable Long id) {
        log.debug("REST request to get ProfessionalHistory by professional ID: {}", id);
        return professionalHistoryRepository.getProfessionalHistoryByPid(id);
    }

    /**
     * {@code GET  /professional-histories/:id} : get the "id" professionalHistory.
     *
     * @param id the id of the professionalHistory to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the professionalHistory, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/professional-histories/{id}")
    public ResponseEntity<ProfessionalHistory> getProfessionalHistory(@PathVariable Long id) {
        log.debug("REST request to get ProfessionalHistory : {}", id);
        return ResponseUtil.wrapOrNotFound(professionalHistoryRepository.findById(id));
    }


    /**
     * {@code DELETE  /professional-histories/:id} : delete the "id" professionalHistory.
     *
     * @param id the id of the professionalHistory to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/professional-histories/{id}")
    public ResponseEntity<Void> deleteProfessionalHistory(@PathVariable Long id) {
        log.debug("REST request to delete ProfessionalHistory : {}", id);
        professionalHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
