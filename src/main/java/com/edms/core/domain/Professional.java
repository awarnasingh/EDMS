package com.edms.core.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A Professional.
 */
@Entity
@Table(name = "professional")
public class Professional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name = "location_id")
    private Location location;

    @NotNull
    @Column(name = "total_experience", nullable = false)
    private Double totalExperience;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="job_title_id")
    private JobTitle jobTitle;

    @Column(name = "type_of_role")
    private String typeOfRole;

    @Column(name = "skill_category")
    private String skillCategory;

    @Column(name = "specific_skills")
    private String specificSkills;

    @Column(name = "general_skills")
    private String generalSkills;
    
    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="client_domain_id")
    private ClientDomain clientDomain;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="mode_id")
    private Mode mode;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="employer_id")
    private Employer employer;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="prime_vendor_id")
    private PrimeVendor primeVendor;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="end_client_id")
    private EndClient endClient;

    @Column(name = "current_project_start_date")
    private String currentProjectStartDate;

    @Column(name = "current_project_end_date")
    private LocalDate currentProjectEndDate;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "sell_rate")
    private String sellRate;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="work_authorization_id")
    private WorkAuthorization workAuthorization;

    @Column(name = "added_on")
    private String addedOn;

    @Column(name = "bench_age")
    private String benchAge;

    @Column(name = "technology")
    private String technology;

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="pay_type_id")
    private PayType payType;

    @Column(name = "additional_notifiers")
    private String additionalNotifiers;

    @Column(name = "source")
    private String source;

    @Column(name = "work_experience")
    private String workExperience;

    @Column(name = "primary_skills")
    private String primarySkills;

    @Column(name = "sell_rate_helper")
    private Double sellRateHelper;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private Employee employee;
    
    
    @Column(name = "layer_one")
    private String layerOne;

    @Column(name = "layer_two")
    private String layerTwo;
    
    @Column(name = "layer_three")
    private String layerThree;
    
    @Column(name = "layer_four")
    private String layerFour;
    
    @Column(name = "srs_joining_date")
    private String srsJoiningDate;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not
    // remove

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public Professional location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getTotalExperience() {
        return totalExperience;
    }

    public Professional totalExperience(Double totalExperience) {
        this.totalExperience = totalExperience;
        return this;
    }

    public void setTotalExperience(Double totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getTypeOfRole() {
        return typeOfRole;
    }

    public Professional typeOfRole(String typeOfRole) {
        this.typeOfRole = typeOfRole;
        return this;
    }

    public void setTypeOfRole(String typeOfRole) {
        this.typeOfRole = typeOfRole;
    }

    public String getSkillCategory() {
        return skillCategory;
    }

    public Professional skillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
        return this;
    }

    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
    }

    public String getSpecificSkills() {
        return specificSkills;
    }

    public Professional specificSkills(String specificSkills) {
        this.specificSkills = specificSkills;
        return this;
    }

    public void setSpecificSkills(String specificSkills) {
        this.specificSkills = specificSkills;
    }

    public String getGeneralSkills() {
        return generalSkills;
    }

    public Professional generalSkills(String generalSkills) {
        this.generalSkills = generalSkills;
        return this;
    }

    public void setGeneralSkills(String generalSkills) {
        this.generalSkills = generalSkills;
    }

    public ClientDomain getClientDomain() {
        return clientDomain;
    }

    public Professional clientDomain(ClientDomain clientDomain) {
        this.clientDomain = clientDomain;
        return this;
    }

    public void setClientDomain(ClientDomain clientDomain) {
        this.clientDomain = clientDomain;
    }

    public Mode getMode() {
        return mode;
    }

    public Professional mode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Professional employer(Employer employer) {
        this.employer = employer;
        return this;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public PrimeVendor getPrimeVendor() {
        return primeVendor;
    }

    public Professional primeVendor(PrimeVendor primeVendor) {
        this.primeVendor = primeVendor;
        return this;
    }

    public void setPrimeVendor(PrimeVendor primeVendor) {
        this.primeVendor = primeVendor;
    }

    public EndClient getEndClient() {
        return endClient;
    }

    public Professional endClient(EndClient endClient) {
        this.endClient = endClient;
        return this;
    }

    public void setEndClient(EndClient endClient) {
        this.endClient = endClient;
    }

    public String getCurrentProjectStartDate() {
        return currentProjectStartDate;
    }

    public Professional currentProjectStartDate(String currentProjectStartDate) {
        this.currentProjectStartDate = currentProjectStartDate;
        return this;
    }

    public void setCurrentProjectStartDate(String currentProjectStartDate) {
        this.currentProjectStartDate = currentProjectStartDate;
    }

    public LocalDate getCurrentProjectEndDate() {
        return currentProjectEndDate;
    }

    public Professional currentProjectEndDate(LocalDate currentProjectEndDate) {
        this.currentProjectEndDate = currentProjectEndDate;
        return this;
    }

    public void setCurrentProjectEndDate(LocalDate currentProjectEndDate) {
        this.currentProjectEndDate = currentProjectEndDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public Professional remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Professional createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Professional createdDate(LocalDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Professional updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public Professional updatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Professional employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Professional)) {
            return false;
        }
        return id != null && id.equals(((Professional) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Professional jobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getSellRate() {
        return sellRate;
    }

    public void setSellRate(String sellRate) {
        this.sellRate = sellRate;
    }

    public WorkAuthorization getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(WorkAuthorization workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getBenchAge() {
        return benchAge;
    }

    public void setBenchAge(String benchAge) {
        this.benchAge = benchAge;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public String getAdditionalNotifiers() {
        return additionalNotifiers;
    }

    public void setAdditionalNotifiers(String additionalNotifiers) {
        this.additionalNotifiers = additionalNotifiers;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getPrimarySkills() {
        return primarySkills;
    }

    public void setPrimarySkills(String primarySkills) {
        this.primarySkills = primarySkills;
    }

    public Double getSellRateHelper() {
        return sellRateHelper;
    }

    public void setSellRateHelper(Double sellRateHelper) {
        this.sellRateHelper = sellRateHelper;
    }
    
    public String getLayerOne() {
		return layerOne;
	}

	public void setLayerOne(String layerOne) {
		this.layerOne = layerOne;
	}

	public String getLayerTwo() {
		return layerTwo;
	}

	public void setLayerTwo(String layerTwo) {
		this.layerTwo = layerTwo;
	}

	public String getLayerThree() {
		return layerThree;
	}

	public void setLayerThree(String layerThree) {
		this.layerThree = layerThree;
	}

	public String getLayerFour() {
		return layerFour;
	}

	public void setLayerFour(String layerFour) {
		this.layerFour = layerFour;
	}

	public String getSrsJoiningDate() {
		return srsJoiningDate;
	}

	public void setSrsJoiningDate(String srsJoiningDate) {
		this.srsJoiningDate = srsJoiningDate;
	}

	@Override
	public String toString() {
		return "Professional [id=" + id + ", city=" + city + ", location=" + location + ", totalExperience="
				+ totalExperience + ", jobTitle=" + jobTitle + ", typeOfRole=" + typeOfRole + ", skillCategory="
				+ skillCategory + ", specificSkills=" + specificSkills + ", generalSkills=" + generalSkills
				+ ", layerOne=" + layerOne + ", layerTwo=" + layerTwo + ", layerThree=" + layerThree + ", layerFour="
				+ layerFour + ", srsJoiningDate=" + srsJoiningDate + ", clientDomain=" + clientDomain + ", mode=" + mode
				+ ", employer=" + employer + ", primeVendor=" + primeVendor + ", endClient=" + endClient
				+ ", currentProjectStartDate=" + currentProjectStartDate + ", currentProjectEndDate="
				+ currentProjectEndDate + ", remarks=" + remarks + ", sellRate=" + sellRate + ", workAuthorization="
				+ workAuthorization + ", addedOn=" + addedOn + ", benchAge=" + benchAge + ", technology=" + technology
				+ ", payType=" + payType + ", additionalNotifiers=" + additionalNotifiers + ", source=" + source
				+ ", workExperience=" + workExperience + ", primarySkills=" + primarySkills + ", sellRateHelper="
				+ sellRateHelper + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", employee=" + employee + "]";
	}
}
