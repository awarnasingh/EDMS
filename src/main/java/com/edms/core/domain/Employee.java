package com.edms.core.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(unique = true)
    private EmpType empType;

    @Column(name = "srs_emp_id")
    private String srsEmpId;

    @NotNull
    @Column(name = "full_name", nullable = false)
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
    
    @Column(name = "DOB")
    private String DOB;

    @ManyToOne(cascade = CascadeType.REFRESH)
   	@JoinColumn(unique = true)
    private Status status;

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

    public EmpType getEmpType() {
        return empType;
    }

    public Employee empType(EmpType empType) {
        this.empType = empType;
        return this;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }

    public String getSrsEmpId() {
        return srsEmpId;
    }

    public Employee srsEmpId(String srsEmpId) {
        this.srsEmpId = srsEmpId;
        return this;
    }

    public void setSrsEmpId(String srsEmpId) {
        this.srsEmpId = srsEmpId;
    }

    public String getFullName() {
        return fullName;
    }

    public Employee fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEducation() {
        return education;
    }

    public Employee education(String education) {
        this.education = education;
        return this;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCertification() {
        return certification;
    }

    public Employee certification(String certification) {
        this.certification = certification;
        return this;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getEmail() {
        return email;
    }

    public Employee email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Status getStatus() {
        return status;
    }

    public Employee status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Employee createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Employee createdDate(LocalDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Employee updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public Employee updatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empType=" + empType + ", srsEmpId=" + srsEmpId + ", fullName=" + fullName
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", education=" + education
				+ ", certification=" + certification + ", email=" + email + ", homePhone=" + homePhone
				+ ", mobileNumber=" + mobileNumber + ", workPhoneNumber=" + workPhoneNumber + ", DOB=" + DOB
				+ ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}


}

