package com.edms.core.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "export_history")
public class ExportHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "export_date")
    private LocalDateTime exportDate;

    @Column(name = "export_download")
    private Boolean exportDownload;

    @Column(name = "export_mail")
    private Boolean exportMail;

    @Column(name = "row_count")
    private Integer rowCount;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmpType empType;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClientDomain domain;

    @Column(name = "from_experience")
    private Double fromExperience;

    @Column(name = "to_experience")
    private Double toExperience;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private EndClient endClient;

    @Column(name = "skills")
    private String skills;

    @Column(name = "employee_name")
    private String employeeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public LocalDateTime getExportDate() {
        return exportDate;
    }

    public void setExportDate(LocalDateTime localDateTime) {
        this.exportDate = localDateTime;
    }

    public Boolean getExportDownload() {
        return exportDownload;
    }

    public void setExportDownload(Boolean exportDownload) {
        this.exportDownload = exportDownload;
    }

    public Boolean getExportMail() {
        return exportMail;
    }

    public void setExportMail(Boolean exportMail) {
        this.exportMail = exportMail;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }

    public ClientDomain getDomain() {
        return domain;
    }

    public void setDomain(ClientDomain domain) {
        this.domain = domain;
    }

    public Double getFromExperience() {
        return fromExperience;
    }

    public void setFromExperience(Double fromExperience) {
        this.fromExperience = fromExperience;
    }

    public Double getToExperience() {
        return toExperience;
    }

    public void setToExperience(Double toExperience) {
        this.toExperience = toExperience;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public EndClient getEndClient() {
        return endClient;
    }

    public void setEndClient(EndClient endClient) {
        this.endClient = endClient;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

	@Override
	public String toString() {
		return "ExportHistory [id=" + id + ", userID=" + userID + ", exportDate=" + exportDate + ", exportDownload="
				+ exportDownload + ", exportMail=" + exportMail + ", rowCount=" + rowCount + ", empType=" + empType
				+ ", domain=" + domain + ", fromExperience=" + fromExperience + ", toExperience=" + toExperience
				+ ", location=" + location + ", status=" + status + ", endClient=" + endClient + ", skills=" + skills
				+ ", employeeName=" + employeeName + "]";
	}


}
