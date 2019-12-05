package com.edms.core.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A ProfessionalHistory.
 */
@Entity
@Table(name = "professional_history")
public class ProfessionalHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "professional_id")
    private Long professionalId;

    @Column(name = "emp_type")
    private String empType;

    @Column(name = "srs_emp_id")
    private String srsEmpId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "education")
    private String education;

    @Column(name = "certification")
    private String certification;

    @Column(name = "email")
    private String email;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "work_phone_number")
    private String workPhoneNumber;

    @Column(name = "d_ob")
    private String dOB;

    @Column(name = "status")
    private String status;

    @Column(name = "city")
    private String city;

    @Column(name = "location")
    private String location;

    @Column(name = "total_experience")
    private Double totalExperience;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "type_of_role")
    private String typeOfRole;

    @Column(name = "skill_category")
    private String skillCategory;

    @Column(name = "specific_skills")
    private String specificSkills;

    @Column(name = "general_skills")
    private String generalSkills;

    @Column(name = "client_domain")
    private String clientDomain;

    @Column(name = "jhi_mode")
    private String mode;

    @Column(name = "employer")
    private String employer;

    @Column(name = "prime_vendor")
    private String primeVendor;

    @Column(name = "end_client")
    private String endClient;
    
    
    
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
    
    

    @Column(name = "current_project_start_date")
    private String currentProjectStartDate;

    @Column(name = "current_project_end_date")
    private LocalDate currentProjectEndDate;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "sell_rate")
    private String sellRate;

    @Column(name = "work_authorization")
    private String workAuthorization;

    @Column(name = "added_on")
    private String addedOn;

    @Column(name = "bench_age")
    private String benchAge;

    @Column(name = "technology")
    private String technology;

    @Column(name = "pay_type")
    private String payType;

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

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public ProfessionalHistory professionalId(Long professionalId) {
        this.professionalId = professionalId;
        return this;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public String getEmpType() {
        return empType;
    }

    public ProfessionalHistory empType(String empType) {
        this.empType = empType;
        return this;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getSrsEmpId() {
        return srsEmpId;
    }

    public ProfessionalHistory srsEmpId(String srsEmpId) {
        this.srsEmpId = srsEmpId;
        return this;
    }

    public void setSrsEmpId(String srsEmpId) {
        this.srsEmpId = srsEmpId;
    }

    public String getFullName() {
        return fullName;
    }

    public ProfessionalHistory fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProfessionalHistory firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfessionalHistory lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEducation() {
        return education;
    }

    public ProfessionalHistory education(String education) {
        this.education = education;
        return this;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCertification() {
        return certification;
    }

    public ProfessionalHistory certification(String certification) {
        this.certification = certification;
        return this;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getEmail() {
        return email;
    }

    public ProfessionalHistory email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ProfessionalHistory homePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public ProfessionalHistory mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public ProfessionalHistory workPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
        return this;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public String getdOB() {
        return dOB;
    }

    public ProfessionalHistory dOB(String dOB) {
        this.dOB = dOB;
        return this;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getStatus() {
        return status;
    }

    public ProfessionalHistory status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public ProfessionalHistory city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public ProfessionalHistory location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTotalExperience() {
        return totalExperience;
    }

    public ProfessionalHistory totalExperience(Double totalExperience) {
        this.totalExperience = totalExperience;
        return this;
    }

    public void setTotalExperience(Double totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public ProfessionalHistory jobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getTypeOfRole() {
        return typeOfRole;
    }

    public ProfessionalHistory typeOfRole(String typeOfRole) {
        this.typeOfRole = typeOfRole;
        return this;
    }

    public void setTypeOfRole(String typeOfRole) {
        this.typeOfRole = typeOfRole;
    }

    public String getSkillCategory() {
        return skillCategory;
    }

    public ProfessionalHistory skillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
        return this;
    }

    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
    }

    public String getSpecificSkills() {
        return specificSkills;
    }

    public ProfessionalHistory specificSkills(String specificSkills) {
        this.specificSkills = specificSkills;
        return this;
    }

    public void setSpecificSkills(String specificSkills) {
        this.specificSkills = specificSkills;
    }

    public String getGeneralSkills() {
        return generalSkills;
    }

    public ProfessionalHistory generalSkills(String generalSkills) {
        this.generalSkills = generalSkills;
        return this;
    }

    public void setGeneralSkills(String generalSkills) {
        this.generalSkills = generalSkills;
    }

    public String getClientDomain() {
        return clientDomain;
    }

    public ProfessionalHistory clientDomain(String clientDomain) {
        this.clientDomain = clientDomain;
        return this;
    }

    public void setClientDomain(String clientDomain) {
        this.clientDomain = clientDomain;
    }

    public String getMode() {
        return mode;
    }

    public ProfessionalHistory mode(String mode) {
        this.mode = mode;
        return this;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getEmployer() {
        return employer;
    }

    public ProfessionalHistory employer(String employer) {
        this.employer = employer;
        return this;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getPrimeVendor() {
        return primeVendor;
    }

    public ProfessionalHistory primeVendor(String primeVendor) {
        this.primeVendor = primeVendor;
        return this;
    }

    public void setPrimeVendor(String primeVendor) {
        this.primeVendor = primeVendor;
    }

    public String getEndClient() {
        return endClient;
    }

    public ProfessionalHistory endClient(String endClient) {
        this.endClient = endClient;
        return this;
    }

    public void setEndClient(String endClient) {
        this.endClient = endClient;
    }

    public String getCurrentProjectStartDate() {
        return currentProjectStartDate;
    }

    public ProfessionalHistory currentProjectStartDate(String currentProjectStartDate) {
        this.currentProjectStartDate = currentProjectStartDate;
        return this;
    }

    public void setCurrentProjectStartDate(String currentProjectStartDate) {
        this.currentProjectStartDate = currentProjectStartDate;
    }

    public LocalDate getCurrentProjectEndDate() {
        return currentProjectEndDate;
    }

    public ProfessionalHistory currentProjectEndDate(LocalDate currentProjectEndDate) {
        this.currentProjectEndDate = currentProjectEndDate;
        return this;
    }

    public void setCurrentProjectEndDate(LocalDate currentProjectEndDate) {
        this.currentProjectEndDate = currentProjectEndDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public ProfessionalHistory remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSellRate() {
        return sellRate;
    }

    public ProfessionalHistory sellRate(String sellRate) {
        this.sellRate = sellRate;
        return this;
    }

    public void setSellRate(String sellRate) {
        this.sellRate = sellRate;
    }

    public String getWorkAuthorization() {
        return workAuthorization;
    }

    public ProfessionalHistory workAuthorization(String workAuthorization) {
        this.workAuthorization = workAuthorization;
        return this;
    }

    public void setWorkAuthorization(String workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public ProfessionalHistory addedOn(String addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getBenchAge() {
        return benchAge;
    }

    public ProfessionalHistory benchAge(String benchAge) {
        this.benchAge = benchAge;
        return this;
    }

    public void setBenchAge(String benchAge) {
        this.benchAge = benchAge;
    }

    public String getTechnology() {
        return technology;
    }

    public ProfessionalHistory technology(String technology) {
        this.technology = technology;
        return this;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getPayType() {
        return payType;
    }

    public ProfessionalHistory payType(String payType) {
        this.payType = payType;
        return this;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAdditionalNotifiers() {
        return additionalNotifiers;
    }

    public ProfessionalHistory additionalNotifiers(String additionalNotifiers) {
        this.additionalNotifiers = additionalNotifiers;
        return this;
    }

    public void setAdditionalNotifiers(String additionalNotifiers) {
        this.additionalNotifiers = additionalNotifiers;
    }

    public String getSource() {
        return source;
    }

    public ProfessionalHistory source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public ProfessionalHistory workExperience(String workExperience) {
        this.workExperience = workExperience;
        return this;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getPrimarySkills() {
        return primarySkills;
    }

    public ProfessionalHistory primarySkills(String primarySkills) {
        this.primarySkills = primarySkills;
        return this;
    }

    public void setPrimarySkills(String primarySkills) {
        this.primarySkills = primarySkills;
    }

    public Double getSellRateHelper() {
        return sellRateHelper;
    }

    public ProfessionalHistory sellRateHelper(Double sellRateHelper) {
        this.sellRateHelper = sellRateHelper;
        return this;
    }

    public void setSellRateHelper(Double sellRateHelper) {
        this.sellRateHelper = sellRateHelper;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ProfessionalHistory createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public ProfessionalHistory createdDate(LocalDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public ProfessionalHistory updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public ProfessionalHistory updatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
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
    
    
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProfessionalHistory)) {
            return false;
        }
        return id != null && id.equals(((ProfessionalHistory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    } 
    
    
    @Override
    public String toString() {
        return "ProfessionalHistory{" +
                "id=" + getId() +
                ", professionalId=" + getProfessionalId() +
                ", empType='" + getEmpType() + "'" +
                ", srsEmpId='" + getSrsEmpId() + "'" +
                ", fullName='" + getFullName() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", education='" + getEducation() + "'" +
                ", certification='" + getCertification() + "'" +
                ", email='" + getEmail() + "'" +
                ", homePhone='" + getHomePhone() + "'" +
                ", mobileNumber='" + getMobileNumber() + "'" +
                ", workPhoneNumber='" + getWorkPhoneNumber() + "'" +
                ", dOB='" + getdOB() + "'" +
                ", status='" + getStatus() + "'" +
                ", city='" + getCity() + "'" +
                ", location='" + getLocation() + "'" +
                ", totalExperience=" + getTotalExperience() +
                ", jobTitle='" + getJobTitle() + "'" +
                ", typeOfRole='" + getTypeOfRole() + "'" +
                ", skillCategory='" + getSkillCategory() + "'" +
                ", specificSkills='" + getSpecificSkills() + "'" +
                ", generalSkills='" + getGeneralSkills() + "'" +
                ", clientDomain='" + getClientDomain() + "'" +
                ", mode='" + getMode() + "'" +
                ", employer='" + getEmployer() + "'" +
                ", primeVendor='" + getPrimeVendor() + "'" +
                ", endClient='" + getEndClient() + "'" +
                ", currentProjectStartDate='" + getCurrentProjectStartDate() + "'" +
                ", currentProjectEndDate='" + getCurrentProjectEndDate() + "'" +
                ", remarks='" + getRemarks() + "'" +
                ", sellRate='" + getSellRate() + "'" +
                ", workAuthorization='" + getWorkAuthorization() + "'" +
                ", addedOn='" + getAddedOn() + "'" +
                ", benchAge='" + getBenchAge() + "'" +
                ", technology='" + getTechnology() + "'" +
                ", payType='" + getPayType() + "'" +
                ", additionalNotifiers='" + getAdditionalNotifiers() + "'" +
                ", source='" + getSource() + "'" +
                ", workExperience='" + getWorkExperience() + "'" +
                ", primarySkills='" + getPrimarySkills() + "'" +
                ", sellRateHelper=" + getSellRateHelper() +
                ", createdBy='" + getCreatedBy() + "'" +
                ", createdDate='" + getCreatedDate() + "'" +
                ", updatedBy='" + getUpdatedBy() + "'" +
                ", updatedDate='" + getUpdatedDate() + "'" +
                ", layerOne='" + getLayerOne() + "'" +
                ", layerTwo='" + getLayerTwo() + "'" +
                ", layerThree='" + getLayerThree() + "'" +
                ", layerFour='" + getLayerFour() + "'" +
                ", srsJoiningDate='" + getSrsJoiningDate() + "'" +
                "}";
    }
}