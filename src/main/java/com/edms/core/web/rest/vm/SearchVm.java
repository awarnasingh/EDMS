package com.edms.core.web.rest.vm;

/**
 * @author anurag
 *
 */
public class SearchVm {
	
	String type;
	String location;
	String domain;
	Double expStart;
	Double expEnd;
	String status;
	String skills;
	String endClient;
	String fullName;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Double getExpStart() {
		return expStart;
	}
	public void setExpStart(Double expStart) {
		this.expStart = expStart;
	}
	public Double getExpEnd() {
		return expEnd;
	}
	public void setExpEnd(Double expEnd) {
		this.expEnd = expEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getEndClient() {
		return endClient;
	}
	public void setEndClient(String endClient) {
		this.endClient = endClient;
	}
	
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "SearchVm [type=" + type + ", location=" + location + ", domain=" + domain + ", expStart=" + expStart
				+ ", expEnd=" + expEnd + ", status=" + status + ", skills=" + skills + ", endClient=" + endClient
				+ ", fullName=" + fullName + "]";
	}
	

	
	
	}

