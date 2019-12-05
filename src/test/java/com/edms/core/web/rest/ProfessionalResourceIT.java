/*
package com.edms.core.web.rest;

import com.edms.core.EdmsApp;
import com.edms.core.domain.Professional;
import com.edms.core.repository.ProfessionalRepository;
import com.edms.core.service.ProfessionalService;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.edms.core.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = EdmsApp.class)
public class ProfessionalResourceIT {

    private static final String DEFAULT_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION = "BBBBBBBBBB";

    private static final Double DEFAULT_TOTAL_EXPERIENCE = 1D;
    private static final Double UPDATED_TOTAL_EXPERIENCE = 2D;

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_OF_ROLE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_OF_ROLE = "BBBBBBBBBB";

    private static final String DEFAULT_SKILL_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_SKILL_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_SPECIFIC_SKILLS = "AAAAAAAAAA";
    private static final String UPDATED_SPECIFIC_SKILLS = "BBBBBBBBBB";

    private static final String DEFAULT_GENERAL_SKILLS = "AAAAAAAAAA";
    private static final String UPDATED_GENERAL_SKILLS = "BBBBBBBBBB";

    private static final String DEFAULT_CLIENT_DOMAIN = "AAAAAAAAAA";
    private static final String UPDATED_CLIENT_DOMAIN = "BBBBBBBBBB";

    private static final String DEFAULT_MODE = "AAAAAAAAAA";
    private static final String UPDATED_MODE = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYER = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYER = "BBBBBBBBBB";

    private static final String DEFAULT_PRIME_VENDOR = "AAAAAAAAAA";
    private static final String UPDATED_PRIME_VENDOR = "BBBBBBBBBB";

    private static final String DEFAULT_END_CLIENT = "AAAAAAAAAA";
    private static final String UPDATED_END_CLIENT = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CURRENT_PROJECT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CURRENT_PROJECT_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CURRENT_PROJECT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CURRENT_PROJECT_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_REMARKS = "AAAAAAAAAA";
    private static final String UPDATED_REMARKS = "BBBBBBBBBB";

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CREATED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_UPDATED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProfessionalService professionalService;

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

    private MockMvc restProfessionalMockMvc;

    private Professional professional;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProfessionalResource professionalResource = new ProfessionalResource(professionalService);
        this.restProfessionalMockMvc = MockMvcBuilders.standaloneSetup(professionalResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }
*/
    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
  /*  public static Professional createEntity(EntityManager em) {
        Professional professional = new Professional()
            .location(DEFAULT_LOCATION)
            .totalExperience(DEFAULT_TOTAL_EXPERIENCE)
            .title(DEFAULT_TITLE)
            .typeOfRole(DEFAULT_TYPE_OF_ROLE)
            .skillCategory(DEFAULT_SKILL_CATEGORY)
            .specificSkills(DEFAULT_SPECIFIC_SKILLS)
            .generalSkills(DEFAULT_GENERAL_SKILLS)
            .clientDomain(DEFAULT_CLIENT_DOMAIN)
            .mode(DEFAULT_MODE)
            .employer(DEFAULT_EMPLOYER)
            .primeVendor(DEFAULT_PRIME_VENDOR)
            .endClient(DEFAULT_END_CLIENT)
            .currentProjectStartDate(DEFAULT_CURRENT_PROJECT_START_DATE)
            .currentProjectEndDate(DEFAULT_CURRENT_PROJECT_END_DATE)
            .remarks(DEFAULT_REMARKS)
            .createdBy(DEFAULT_CREATED_BY)
            .createdDate(DEFAULT_CREATED_DATE)
            .updatedBy(DEFAULT_UPDATED_BY)
            .updatedDate(DEFAULT_UPDATED_DATE);
        return professional;
    }*/
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    
/* public static Professional createUpdatedEntity(EntityManager em) {
        Professional professional = new Professional()
            .location(UPDATED_LOCATION)
            .totalExperience(UPDATED_TOTAL_EXPERIENCE)
            .title(UPDATED_TITLE)
            .typeOfRole(UPDATED_TYPE_OF_ROLE)
            .skillCategory(UPDATED_SKILL_CATEGORY)
            .specificSkills(UPDATED_SPECIFIC_SKILLS)
            .generalSkills(UPDATED_GENERAL_SKILLS)
            .clientDomain(UPDATED_CLIENT_DOMAIN)
            .mode(UPDATED_MODE)
            .employer(UPDATED_EMPLOYER)
            .primeVendor(UPDATED_PRIME_VENDOR)
            .endClient(UPDATED_END_CLIENT)
            .currentProjectStartDate(UPDATED_CURRENT_PROJECT_START_DATE)
            .currentProjectEndDate(UPDATED_CURRENT_PROJECT_END_DATE)
            .remarks(UPDATED_REMARKS)
            .createdBy(UPDATED_CREATED_BY)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedDate(UPDATED_UPDATED_DATE);
        return professional;
    }

    @BeforeEach
    public void initTest() {
        professional = createEntity(em);
    }

    @Test
    @Transactional
    public void createProfessional() throws Exception {
        int databaseSizeBeforeCreate = professionalRepository.findAll().size();

        // Create the Professional
        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isCreated());

        // Validate the Professional in the database
        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeCreate + 1);
        Professional testProfessional = professionalList.get(professionalList.size() - 1);
        assertThat(testProfessional.getLocation()).isEqualTo(DEFAULT_LOCATION);
        assertThat(testProfessional.getTotalExperience()).isEqualTo(DEFAULT_TOTAL_EXPERIENCE);
        assertThat(testProfessional.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testProfessional.getTypeOfRole()).isEqualTo(DEFAULT_TYPE_OF_ROLE);
        assertThat(testProfessional.getSkillCategory()).isEqualTo(DEFAULT_SKILL_CATEGORY);
        assertThat(testProfessional.getSpecificSkills()).isEqualTo(DEFAULT_SPECIFIC_SKILLS);
        assertThat(testProfessional.getGeneralSkills()).isEqualTo(DEFAULT_GENERAL_SKILLS);
        assertThat(testProfessional.getClientDomain()).isEqualTo(DEFAULT_CLIENT_DOMAIN);
        assertThat(testProfessional.getMode()).isEqualTo(DEFAULT_MODE);
        assertThat(testProfessional.getEmployer()).isEqualTo(DEFAULT_EMPLOYER);
        assertThat(testProfessional.getPrimeVendor()).isEqualTo(DEFAULT_PRIME_VENDOR);
        assertThat(testProfessional.getEndClient()).isEqualTo(DEFAULT_END_CLIENT);
        assertThat(testProfessional.getCurrentProjectStartDate()).isEqualTo(DEFAULT_CURRENT_PROJECT_START_DATE);
        assertThat(testProfessional.getCurrentProjectEndDate()).isEqualTo(DEFAULT_CURRENT_PROJECT_END_DATE);
        assertThat(testProfessional.getRemarks()).isEqualTo(DEFAULT_REMARKS);
        assertThat(testProfessional.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testProfessional.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testProfessional.getUpdatedBy()).isEqualTo(DEFAULT_UPDATED_BY);
        assertThat(testProfessional.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
    }

    @Test
    @Transactional
    public void createProfessionalWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = professionalRepository.findAll().size();

        // Create the Professional with an existing ID
        professional.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        // Validate the Professional in the database
        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkLocationIsRequired() throws Exception {
        int databaseSizeBeforeTest = professionalRepository.findAll().size();
        // set the field null
        professional.setLocation(null);

        // Create the Professional, which fails.

        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTotalExperienceIsRequired() throws Exception {
        int databaseSizeBeforeTest = professionalRepository.findAll().size();
        // set the field null
        professional.setTotalExperience(null);

        // Create the Professional, which fails.

        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkClientDomainIsRequired() throws Exception {
        int databaseSizeBeforeTest = professionalRepository.findAll().size();
        // set the field null
        professional.setClientDomain(null);

        // Create the Professional, which fails.

        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEmployerIsRequired() throws Exception {
        int databaseSizeBeforeTest = professionalRepository.findAll().size();
        // set the field null
        professional.setEmployer(null);

        // Create the Professional, which fails.

        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPrimeVendorIsRequired() throws Exception {
        int databaseSizeBeforeTest = professionalRepository.findAll().size();
        // set the field null
        professional.setPrimeVendor(null);

        // Create the Professional, which fails.

        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEndClientIsRequired() throws Exception {
        int databaseSizeBeforeTest = professionalRepository.findAll().size();
        // set the field null
        professional.setEndClient(null);

        // Create the Professional, which fails.

        restProfessionalMockMvc.perform(post("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProfessionals() throws Exception {
        // Initialize the database
        professionalRepository.saveAndFlush(professional);

        // Get all the professionalList
        restProfessionalMockMvc.perform(get("/api/professionals?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(professional.getId().intValue())))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].totalExperience").value(hasItem(DEFAULT_TOTAL_EXPERIENCE.doubleValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].typeOfRole").value(hasItem(DEFAULT_TYPE_OF_ROLE.toString())))
            .andExpect(jsonPath("$.[*].skillCategory").value(hasItem(DEFAULT_SKILL_CATEGORY.toString())))
            .andExpect(jsonPath("$.[*].specificSkills").value(hasItem(DEFAULT_SPECIFIC_SKILLS.toString())))
            .andExpect(jsonPath("$.[*].generalSkills").value(hasItem(DEFAULT_GENERAL_SKILLS.toString())))
            .andExpect(jsonPath("$.[*].clientDomain").value(hasItem(DEFAULT_CLIENT_DOMAIN.toString())))
            .andExpect(jsonPath("$.[*].mode").value(hasItem(DEFAULT_MODE.toString())))
            .andExpect(jsonPath("$.[*].employer").value(hasItem(DEFAULT_EMPLOYER.toString())))
            .andExpect(jsonPath("$.[*].primeVendor").value(hasItem(DEFAULT_PRIME_VENDOR.toString())))
            .andExpect(jsonPath("$.[*].endClient").value(hasItem(DEFAULT_END_CLIENT.toString())))
            .andExpect(jsonPath("$.[*].currentProjectStartDate").value(hasItem(DEFAULT_CURRENT_PROJECT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].currentProjectEndDate").value(hasItem(DEFAULT_CURRENT_PROJECT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].remarks").value(hasItem(DEFAULT_REMARKS.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.toString())))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(DEFAULT_CREATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.toString())))
            .andExpect(jsonPath("$.[*].updatedDate").value(hasItem(DEFAULT_UPDATED_DATE.toString())));
    }
    
    @Test
    @Transactional
    public void getProfessional() throws Exception {
        // Initialize the database
        professionalRepository.saveAndFlush(professional);

        // Get the professional
        restProfessionalMockMvc.perform(get("/api/professionals/{id}", professional.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(professional.getId().intValue()))
            .andExpect(jsonPath("$.location").value(DEFAULT_LOCATION.toString()))
            .andExpect(jsonPath("$.totalExperience").value(DEFAULT_TOTAL_EXPERIENCE.doubleValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.typeOfRole").value(DEFAULT_TYPE_OF_ROLE.toString()))
            .andExpect(jsonPath("$.skillCategory").value(DEFAULT_SKILL_CATEGORY.toString()))
            .andExpect(jsonPath("$.specificSkills").value(DEFAULT_SPECIFIC_SKILLS.toString()))
            .andExpect(jsonPath("$.generalSkills").value(DEFAULT_GENERAL_SKILLS.toString()))
            .andExpect(jsonPath("$.clientDomain").value(DEFAULT_CLIENT_DOMAIN.toString()))
            .andExpect(jsonPath("$.mode").value(DEFAULT_MODE.toString()))
            .andExpect(jsonPath("$.employer").value(DEFAULT_EMPLOYER.toString()))
            .andExpect(jsonPath("$.primeVendor").value(DEFAULT_PRIME_VENDOR.toString()))
            .andExpect(jsonPath("$.endClient").value(DEFAULT_END_CLIENT.toString()))
            .andExpect(jsonPath("$.currentProjectStartDate").value(DEFAULT_CURRENT_PROJECT_START_DATE.toString()))
            .andExpect(jsonPath("$.currentProjectEndDate").value(DEFAULT_CURRENT_PROJECT_END_DATE.toString()))
            .andExpect(jsonPath("$.remarks").value(DEFAULT_REMARKS.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.toString()))
            .andExpect(jsonPath("$.createdDate").value(DEFAULT_CREATED_DATE.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.toString()))
            .andExpect(jsonPath("$.updatedDate").value(DEFAULT_UPDATED_DATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProfessional() throws Exception {
        // Get the professional
        restProfessionalMockMvc.perform(get("/api/professionals/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProfessional() throws Exception {
        // Initialize the database
        professionalService.save(professional);

        int databaseSizeBeforeUpdate = professionalRepository.findAll().size();

        // Update the professional
        Professional updatedProfessional = professionalRepository.findById(professional.getId()).get();
        // Disconnect from session so that the updates on updatedProfessional are not directly saved in db
        em.detach(updatedProfessional);
        updatedProfessional
            .location(UPDATED_LOCATION)
            .totalExperience(UPDATED_TOTAL_EXPERIENCE)
            .title(UPDATED_TITLE)
            .typeOfRole(UPDATED_TYPE_OF_ROLE)
            .skillCategory(UPDATED_SKILL_CATEGORY)
            .specificSkills(UPDATED_SPECIFIC_SKILLS)
            .generalSkills(UPDATED_GENERAL_SKILLS)
            .clientDomain(UPDATED_CLIENT_DOMAIN)
            .mode(UPDATED_MODE)
            .employer(UPDATED_EMPLOYER)
            .primeVendor(UPDATED_PRIME_VENDOR)
            .endClient(UPDATED_END_CLIENT)
            .currentProjectStartDate(UPDATED_CURRENT_PROJECT_START_DATE)
            .currentProjectEndDate(UPDATED_CURRENT_PROJECT_END_DATE)
            .remarks(UPDATED_REMARKS)
            .createdBy(UPDATED_CREATED_BY)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedDate(UPDATED_UPDATED_DATE);

        restProfessionalMockMvc.perform(put("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedProfessional)))
            .andExpect(status().isOk());

        // Validate the Professional in the database
        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeUpdate);
        Professional testProfessional = professionalList.get(professionalList.size() - 1);
        assertThat(testProfessional.getLocation()).isEqualTo(UPDATED_LOCATION);
        assertThat(testProfessional.getTotalExperience()).isEqualTo(UPDATED_TOTAL_EXPERIENCE);
        assertThat(testProfessional.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testProfessional.getTypeOfRole()).isEqualTo(UPDATED_TYPE_OF_ROLE);
        assertThat(testProfessional.getSkillCategory()).isEqualTo(UPDATED_SKILL_CATEGORY);
        assertThat(testProfessional.getSpecificSkills()).isEqualTo(UPDATED_SPECIFIC_SKILLS);
        assertThat(testProfessional.getGeneralSkills()).isEqualTo(UPDATED_GENERAL_SKILLS);
        assertThat(testProfessional.getClientDomain()).isEqualTo(UPDATED_CLIENT_DOMAIN);
        assertThat(testProfessional.getMode()).isEqualTo(UPDATED_MODE);
        assertThat(testProfessional.getEmployer()).isEqualTo(UPDATED_EMPLOYER);
        assertThat(testProfessional.getPrimeVendor()).isEqualTo(UPDATED_PRIME_VENDOR);
        assertThat(testProfessional.getEndClient()).isEqualTo(UPDATED_END_CLIENT);
        assertThat(testProfessional.getCurrentProjectStartDate()).isEqualTo(UPDATED_CURRENT_PROJECT_START_DATE);
        assertThat(testProfessional.getCurrentProjectEndDate()).isEqualTo(UPDATED_CURRENT_PROJECT_END_DATE);
        assertThat(testProfessional.getRemarks()).isEqualTo(UPDATED_REMARKS);
        assertThat(testProfessional.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testProfessional.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testProfessional.getUpdatedBy()).isEqualTo(UPDATED_UPDATED_BY);
        assertThat(testProfessional.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingProfessional() throws Exception {
        int databaseSizeBeforeUpdate = professionalRepository.findAll().size();

        // Create the Professional

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProfessionalMockMvc.perform(put("/api/professionals")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(professional)))
            .andExpect(status().isBadRequest());

        // Validate the Professional in the database
        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProfessional() throws Exception {
        // Initialize the database
        professionalService.save(professional);

        int databaseSizeBeforeDelete = professionalRepository.findAll().size();

        // Delete the professional
        restProfessionalMockMvc.perform(delete("/api/professionals/{id}", professional.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<Professional> professionalList = professionalRepository.findAll();
        assertThat(professionalList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Professional.class);
        Professional professional1 = new Professional();
        professional1.setId(1L);
        Professional professional2 = new Professional();
        professional2.setId(professional1.getId());
        assertThat(professional1).isEqualTo(professional2);
        professional2.setId(2L);
        assertThat(professional1).isNotEqualTo(professional2);
        professional1.setId(null);
        assertThat(professional1).isNotEqualTo(professional2);
    }
}
*/
