package com.edms.core.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
import com.edms.core.domain.SearchHistory;
import com.edms.core.repository.SearchHistoryRepository;
import com.edms.core.security.SecurityUtils;
import com.edms.core.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.edms.core.domain.SearchHistory}.
 */
@RestController
@RequestMapping("/api")
public class SearchHistoryResource {

    private final Logger log = LoggerFactory.getLogger(SearchHistoryResource.class);

    private static final String ENTITY_NAME = "searchHistory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SearchHistoryRepository searchHistoryRepository;

    public SearchHistoryResource(SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    /**
     * {@code POST  /search-histories} : Create a new searchHistory.
     *
     * @param searchHistory the searchHistory to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new searchHistory, or with status {@code 400 (Bad Request)} if the searchHistory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/search-histories")
    public ResponseEntity<SearchHistory> createSearchHistory(@Valid @RequestBody SearchHistory searchHistory) throws URISyntaxException {
        log.debug("REST request to save SearchHistory : {}", searchHistory);
        if (searchHistory.getId() != null) {
            throw new BadRequestAlertException(ConstantUtils.SEARCHHISTORY_ID_ALREADY_EXISTS, ENTITY_NAME, ConstantUtils.ID_EXISTS);
        }
		String user = SecurityUtils.getCurrentUserLogin().get();
		searchHistory.setUserID(user);
		List<SearchHistory> sHistory= searchHistoryRepository.findBySearchHistoryName(searchHistory.getSearchName());
		if(!sHistory.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
		SearchHistory result = searchHistoryRepository.save(searchHistory);
        return ResponseEntity.created(new URI(ConstantUtils.API_SEARCH_HISTORIES + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }


    /**
     * {@code PUT  /search-histories} : Updates an existing searchHistory.
     *
     * @param searchHistory the searchHistory to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated searchHistory,
     * or with status {@code 400 (Bad Request)} if the searchHistory is not valid,
     * or with status {@code 500 (Internal Server Error)} if the searchHistory couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/search-histories")
    public ResponseEntity<SearchHistory> updateSearchHistory(@Valid @RequestBody SearchHistory searchHistory) throws URISyntaxException {
        log.debug("REST request to update SearchHistory : {}", searchHistory);
        if (searchHistory.getId() == null) {
            throw new BadRequestAlertException(ConstantUtils.INVALID_ID, ENTITY_NAME, ConstantUtils.ID_NULL);
        }
        
        SearchHistory result = searchHistoryRepository.save(searchHistory);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, searchHistory.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /search-histories} : get all the searchHistories.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of searchHistories in body.
     */
    @GetMapping("/search-histories")
    public List<SearchHistory> getAllSearchHistories() {
        log.debug("REST request to get all SearchHistories");
        return searchHistoryRepository.findAll();
    }

    /**
     * {@code GET  /search-histories/:id} : get the "id" searchHistory.
     *
     * @param id the id of the searchHistory to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the searchHistory, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/search-histories/{id}")
    public ResponseEntity<SearchHistory> getSearchHistory(@PathVariable Long id) {
        log.debug("REST request to get SearchHistory : {}", id);
        Optional<SearchHistory> searchHistory = searchHistoryRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(searchHistory);
    }

    /**
     * {@code DELETE  /search-histories/:id} : delete the "id" searchHistory.
     *
     * @param id the id of the searchHistory to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/search-histories/{id}")
    public ResponseEntity<Void> deleteSearchHistory(@PathVariable Long id) {
        log.debug("REST request to delete SearchHistory : {}", id);
        searchHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
