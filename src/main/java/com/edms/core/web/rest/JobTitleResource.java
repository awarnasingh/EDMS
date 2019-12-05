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
import com.edms.core.domain.JobTitle;
import com.edms.core.service.JobTitleService;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class JobTitleResource {
	
	private final Logger log = LoggerFactory.getLogger(JobTitleResource.class);

    private static final String ENTITY_NAME = "JobTitle";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    
    @Autowired
    private JobTitleService jobTitleService;

    /**
     * {@code POST  /jobTitles} : Create a new JobTitle.
     *
     * @param JobTitle the JobTitle to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new JobTitle, or with status {@code 400 (Bad Request)} if the JobTitle has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/jobTitles")
    public ResponseEntity<JobTitle> createJobTitle(@Valid @RequestBody JobTitle jobTitle) throws URISyntaxException {
        log.debug("REST request to save JobTitle : {}", jobTitle);
        if (jobTitle.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.JOBTITLE_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
        JobTitle result = jobTitleService .save(jobTitle);
        return ResponseEntity.created(new URI(ConstantUtils.API_JOBTITLES + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /jobTitles} : Updates an existing JobTitle.
     *
     * @param JobTitle the JobTitle to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated JobTitle,
     * or with status {@code 400 (Bad Request)} if the JobTitle is not valid,
     * or with status {@code 500 (Internal Server Error)} if the JobTitle couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/jobTitles")
    public ResponseEntity<JobTitle> updateJobTitle(@Valid @RequestBody JobTitle jobTitle) throws URISyntaxException {
        log.debug("REST request to update JobTitle : {}", jobTitle);
        if (jobTitle.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        JobTitle result = jobTitleService .save(jobTitle);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, jobTitle.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /jobTitles} : get all the JobTitles.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of JobTitles in body.
     */
    @GetMapping("/jobTitles")
    public List<JobTitle> getAllJobTitles() {
        log.debug("REST request to get all JobTitles");
        return jobTitleService .findAll();
    }

    /**
     * {@code GET  /jobTitles/:id} : get the "id" JobTitle.
     *
     * @param id the id of the JobTitle to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the JobTitle, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/jobTitles/{id}")
    public ResponseEntity<JobTitle> getJobTitle(@PathVariable Long id) {
        log.debug("REST request to get JobTitle : {}", id);
        Optional<JobTitle> jobTitle = jobTitleService .findOne(id);
        return ResponseUtil.wrapOrNotFound(jobTitle);
    }

    /**
     * {@code DELETE  /jobTitles/:id} : delete the "id" JobTitle.
     *
     * @param id the id of the JobTitle to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/jobTitles/{id}")
    public ResponseEntity<Void> deleteJobTitle(@PathVariable Long id) {
        log.debug("REST request to delete JobTitle : {}", id);
        jobTitleService .delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
