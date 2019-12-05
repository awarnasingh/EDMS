package com.edms.core.web.rest;

import com.edms.core.EdmsApp;
import com.edms.core.domain.SearchHistory;
import com.edms.core.repository.SearchHistoryRepository;
import com.edms.core.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.edms.core.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@Link SearchHistoryResource} REST controller.
 */
@SpringBootTest(classes = EdmsApp.class)
public class SearchHistoryResourceIT {

    private static final String DEFAULT_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_USER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SEARCH_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SEARCH_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMP_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EMP_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DOMAIN = "AAAAAAAAAA";
    private static final String UPDATED_DOMAIN = "BBBBBBBBBB";

    private static final Double DEFAULT_FROM_EXPERIENCE = 1D;
    private static final Double UPDATED_FROM_EXPERIENCE = 2D;

    private static final Double DEFAULT_TO_EXPERIENCE = 1D;
    private static final Double UPDATED_TO_EXPERIENCE = 2D;

    private static final String DEFAULT_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_END_CLIENT = "AAAAAAAAAA";
    private static final String UPDATED_END_CLIENT = "BBBBBBBBBB";

    private static final String DEFAULT_SKILLS = "AAAAAAAAAA";
    private static final String UPDATED_SKILLS = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NAME = "BBBBBBBBBB";

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restSearchHistoryMockMvc;

    private SearchHistory searchHistory;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SearchHistoryResource searchHistoryResource = new SearchHistoryResource(searchHistoryRepository);
        this.restSearchHistoryMockMvc = MockMvcBuilders.standaloneSetup(searchHistoryResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SearchHistory createEntity(EntityManager em) {
        SearchHistory searchHistory = new SearchHistory()
            .userID(DEFAULT_USER_ID)
            .searchName(DEFAULT_SEARCH_NAME)
            .empType(DEFAULT_EMP_TYPE)
            .domain(DEFAULT_DOMAIN)
            .fromExperience(DEFAULT_FROM_EXPERIENCE)
            .toExperience(DEFAULT_TO_EXPERIENCE)
            .location(DEFAULT_LOCATION)
            .status(DEFAULT_STATUS)
            .endClient(DEFAULT_END_CLIENT)
            .skills(DEFAULT_SKILLS)
            .employeeName(DEFAULT_EMPLOYEE_NAME);
        return searchHistory;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SearchHistory createUpdatedEntity(EntityManager em) {
        SearchHistory searchHistory = new SearchHistory()
            .userID(UPDATED_USER_ID)
            .searchName(UPDATED_SEARCH_NAME)
            .empType(UPDATED_EMP_TYPE)
            .domain(UPDATED_DOMAIN)
            .fromExperience(UPDATED_FROM_EXPERIENCE)
            .toExperience(UPDATED_TO_EXPERIENCE)
            .location(UPDATED_LOCATION)
            .status(UPDATED_STATUS)
            .endClient(UPDATED_END_CLIENT)
            .skills(UPDATED_SKILLS)
            .employeeName(UPDATED_EMPLOYEE_NAME);
        return searchHistory;
    }

    @BeforeEach
    public void initTest() {
        searchHistory = createEntity(em);
    }

    @Test
    @Transactional
    public void createSearchHistory() throws Exception {
        int databaseSizeBeforeCreate = searchHistoryRepository.findAll().size();

        // Create the SearchHistory
        restSearchHistoryMockMvc.perform(post("/api/search-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(searchHistory)))
            .andExpect(status().isCreated());

        // Validate the SearchHistory in the database
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAll();
        assertThat(searchHistoryList).hasSize(databaseSizeBeforeCreate + 1);
        SearchHistory testSearchHistory = searchHistoryList.get(searchHistoryList.size() - 1);
        assertThat(testSearchHistory.getUserID()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testSearchHistory.getSearchName()).isEqualTo(DEFAULT_SEARCH_NAME);
        assertThat(testSearchHistory.getEmpType()).isEqualTo(DEFAULT_EMP_TYPE);
        assertThat(testSearchHistory.getDomain()).isEqualTo(DEFAULT_DOMAIN);
        assertThat(testSearchHistory.getFromExperience()).isEqualTo(DEFAULT_FROM_EXPERIENCE);
        assertThat(testSearchHistory.getToExperience()).isEqualTo(DEFAULT_TO_EXPERIENCE);
        assertThat(testSearchHistory.getLocation()).isEqualTo(DEFAULT_LOCATION);
        assertThat(testSearchHistory.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSearchHistory.getEndClient()).isEqualTo(DEFAULT_END_CLIENT);
        assertThat(testSearchHistory.getSkills()).isEqualTo(DEFAULT_SKILLS);
        assertThat(testSearchHistory.getEmployeeName()).isEqualTo(DEFAULT_EMPLOYEE_NAME);
    }

    @Test
    @Transactional
    public void createSearchHistoryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = searchHistoryRepository.findAll().size();

        // Create the SearchHistory with an existing ID
        searchHistory.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSearchHistoryMockMvc.perform(post("/api/search-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(searchHistory)))
            .andExpect(status().isBadRequest());

        // Validate the SearchHistory in the database
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAll();
        assertThat(searchHistoryList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSearchHistories() throws Exception {
        // Initialize the database
        searchHistoryRepository.saveAndFlush(searchHistory);

        // Get all the searchHistoryList
        restSearchHistoryMockMvc.perform(get("/api/search-histories?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(searchHistory.getId().intValue())))
            .andExpect(jsonPath("$.[*].userID").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].searchName").value(hasItem(DEFAULT_SEARCH_NAME.toString())))
            .andExpect(jsonPath("$.[*].empType").value(hasItem(DEFAULT_EMP_TYPE.toString())))
            .andExpect(jsonPath("$.[*].domain").value(hasItem(DEFAULT_DOMAIN.toString())))
            .andExpect(jsonPath("$.[*].fromExperience").value(hasItem(DEFAULT_FROM_EXPERIENCE.doubleValue())))
            .andExpect(jsonPath("$.[*].toExperience").value(hasItem(DEFAULT_TO_EXPERIENCE.doubleValue())))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].endClient").value(hasItem(DEFAULT_END_CLIENT.toString())))
            .andExpect(jsonPath("$.[*].skills").value(hasItem(DEFAULT_SKILLS.toString())))
            .andExpect(jsonPath("$.[*].employeeName").value(hasItem(DEFAULT_EMPLOYEE_NAME.toString())));
    }
    
    @Test
    @Transactional
    public void getSearchHistory() throws Exception {
        // Initialize the database
        searchHistoryRepository.saveAndFlush(searchHistory);

        // Get the searchHistory
        restSearchHistoryMockMvc.perform(get("/api/search-histories/{id}", searchHistory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(searchHistory.getId().intValue()))
            .andExpect(jsonPath("$.userID").value(DEFAULT_USER_ID.toString()))
            .andExpect(jsonPath("$.searchName").value(DEFAULT_SEARCH_NAME.toString()))
            .andExpect(jsonPath("$.empType").value(DEFAULT_EMP_TYPE.toString()))
            .andExpect(jsonPath("$.domain").value(DEFAULT_DOMAIN.toString()))
            .andExpect(jsonPath("$.fromExperience").value(DEFAULT_FROM_EXPERIENCE.doubleValue()))
            .andExpect(jsonPath("$.toExperience").value(DEFAULT_TO_EXPERIENCE.doubleValue()))
            .andExpect(jsonPath("$.location").value(DEFAULT_LOCATION.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.endClient").value(DEFAULT_END_CLIENT.toString()))
            .andExpect(jsonPath("$.skills").value(DEFAULT_SKILLS.toString()))
            .andExpect(jsonPath("$.employeeName").value(DEFAULT_EMPLOYEE_NAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingSearchHistory() throws Exception {
        // Get the searchHistory
        restSearchHistoryMockMvc.perform(get("/api/search-histories/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSearchHistory() throws Exception {
        // Initialize the database
        searchHistoryRepository.saveAndFlush(searchHistory);

        int databaseSizeBeforeUpdate = searchHistoryRepository.findAll().size();

        // Update the searchHistory
        SearchHistory updatedSearchHistory = searchHistoryRepository.findById(searchHistory.getId()).get();
        // Disconnect from session so that the updates on updatedSearchHistory are not directly saved in db
        em.detach(updatedSearchHistory);
        updatedSearchHistory
            .userID(UPDATED_USER_ID)
            .searchName(UPDATED_SEARCH_NAME)
            .empType(UPDATED_EMP_TYPE)
            .domain(UPDATED_DOMAIN)
            .fromExperience(UPDATED_FROM_EXPERIENCE)
            .toExperience(UPDATED_TO_EXPERIENCE)
            .location(UPDATED_LOCATION)
            .status(UPDATED_STATUS)
            .endClient(UPDATED_END_CLIENT)
            .skills(UPDATED_SKILLS)
            .employeeName(UPDATED_EMPLOYEE_NAME);

        restSearchHistoryMockMvc.perform(put("/api/search-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSearchHistory)))
            .andExpect(status().isOk());

        // Validate the SearchHistory in the database
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAll();
        assertThat(searchHistoryList).hasSize(databaseSizeBeforeUpdate);
        SearchHistory testSearchHistory = searchHistoryList.get(searchHistoryList.size() - 1);
        assertThat(testSearchHistory.getUserID()).isEqualTo(UPDATED_USER_ID);
        assertThat(testSearchHistory.getSearchName()).isEqualTo(UPDATED_SEARCH_NAME);
        assertThat(testSearchHistory.getEmpType()).isEqualTo(UPDATED_EMP_TYPE);
        assertThat(testSearchHistory.getDomain()).isEqualTo(UPDATED_DOMAIN);
        assertThat(testSearchHistory.getFromExperience()).isEqualTo(UPDATED_FROM_EXPERIENCE);
        assertThat(testSearchHistory.getToExperience()).isEqualTo(UPDATED_TO_EXPERIENCE);
        assertThat(testSearchHistory.getLocation()).isEqualTo(UPDATED_LOCATION);
        assertThat(testSearchHistory.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSearchHistory.getEndClient()).isEqualTo(UPDATED_END_CLIENT);
        assertThat(testSearchHistory.getSkills()).isEqualTo(UPDATED_SKILLS);
        assertThat(testSearchHistory.getEmployeeName()).isEqualTo(UPDATED_EMPLOYEE_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingSearchHistory() throws Exception {
        int databaseSizeBeforeUpdate = searchHistoryRepository.findAll().size();

        // Create the SearchHistory

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSearchHistoryMockMvc.perform(put("/api/search-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(searchHistory)))
            .andExpect(status().isBadRequest());

        // Validate the SearchHistory in the database
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAll();
        assertThat(searchHistoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSearchHistory() throws Exception {
        // Initialize the database
        searchHistoryRepository.saveAndFlush(searchHistory);

        int databaseSizeBeforeDelete = searchHistoryRepository.findAll().size();

        // Delete the searchHistory
        restSearchHistoryMockMvc.perform(delete("/api/search-histories/{id}", searchHistory.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAll();
        assertThat(searchHistoryList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SearchHistory.class);
        SearchHistory searchHistory1 = new SearchHistory();
        searchHistory1.setId(1L);
        SearchHistory searchHistory2 = new SearchHistory();
        searchHistory2.setId(searchHistory1.getId());
        assertThat(searchHistory1).isEqualTo(searchHistory2);
        searchHistory2.setId(2L);
        assertThat(searchHistory1).isNotEqualTo(searchHistory2);
        searchHistory1.setId(null);
        assertThat(searchHistory1).isNotEqualTo(searchHistory2);
    }
}
