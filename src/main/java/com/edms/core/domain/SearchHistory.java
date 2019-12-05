package com.edms.core.domain;



import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A SearchHistory.
 */
@Entity
@Table(name = "search_history")
public class SearchHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userID;

    
    @Column(name = "search_name", unique = true)
    private String searchName;

    @Column(name = "emp_type")
    private String empType;

    @Column(name = "domain")
    private String domain;

    @Column(name = "from_experience")
    private Double fromExperience;

    @Column(name = "to_experience")
    private Double toExperience;

    @Column(name = "location")
    private String location;

    @Column(name = "status")
    private String status;

    @Column(name = "end_client")
    private String endClient;

    @Column(name = "skills")
    private String skills;

    @Column(name = "employee_name")
    private String employeeName;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public SearchHistory userID(String userID) {
        this.userID = userID;
        return this;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSearchName() {
        return searchName;
    }

    public SearchHistory searchName(String searchName) {
        this.searchName = searchName;
        return this;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getEmpType() {
        return empType;
    }

    public SearchHistory empType(String empType) {
        this.empType = empType;
        return this;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getDomain() {
        return domain;
    }

    public SearchHistory domain(String domain) {
        this.domain = domain;
        return this;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Double getFromExperience() {
        return fromExperience;
    }

    public SearchHistory fromExperience(Double fromExperience) {
        this.fromExperience = fromExperience;
        return this;
    }

    public void setFromExperience(Double fromExperience) {
        this.fromExperience = fromExperience;
    }

    public Double getToExperience() {
        return toExperience;
    }

    public SearchHistory toExperience(Double toExperience) {
        this.toExperience = toExperience;
        return this;
    }

    public void setToExperience(Double toExperience) {
        this.toExperience = toExperience;
    }

    public String getLocation() {
        return location;
    }

    public SearchHistory location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public SearchHistory status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndClient() {
        return endClient;
    }

    public SearchHistory endClient(String endClient) {
        this.endClient = endClient;
        return this;
    }

    public void setEndClient(String endClient) {
        this.endClient = endClient;
    }

    public String getSkills() {
        return skills;
    }

    public SearchHistory skills(String skills) {
        this.skills = skills;
        return this;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public SearchHistory employeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SearchHistory)) {
            return false;
        }
        return id != null && id.equals(((SearchHistory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
            "id=" + getId() +
            ", userID='" + getUserID() + "'" +
            ", searchName='" + getSearchName() + "'" +
            ", empType='" + getEmpType() + "'" +
            ", domain='" + getDomain() + "'" +
            ", fromExperience=" + getFromExperience() +
            ", toExperience=" + getToExperience() +
            ", location='" + getLocation() + "'" +
            ", status='" + getStatus() + "'" +
            ", endClient='" + getEndClient() + "'" +
            ", skills='" + getSkills() + "'" +
            ", employeeName='" + getEmployeeName() + "'" +
            "}";
    }
}
