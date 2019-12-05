package com.edms.core.domain;

import java.util.List;

public class Configuration {
	 
	List<EmpType> empType;
	List<WorkAuthorization> workAuthorization;
	List<Status> status;
	List<Location> location;
	List<JobTitle> jobTitle;
	List<Mode> mode;
	List<PayType> payType;
	List<Employer> employer;
	List<ClientDomain> domainList;
	List<EndClient> endClient;
	List<PrimeVendor> primeVendor;

	/**
	 * @return the empType
	 */
	public List<EmpType> getEmpType() {
		return empType;
	}

	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(List<EmpType> empType) {
		this.empType = empType;
	}

	/**
	 * @return the workAuthorization
	 */
	public List<WorkAuthorization> getWorkAuthorization() {
		return workAuthorization;
	}

	/**
	 * @param workAuthorization the workAuthorization to set
	 */
	public void setWorkAuthorization(List<WorkAuthorization> workAuthorization) {
		this.workAuthorization = workAuthorization;
	}

	/**
	 * @return the status
	 */
	public List<Status> getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(List<Status> status) {
		this.status = status;
	}

	/**
	 * @return the location
	 */
	public List<Location> getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(List<Location> location) {
		this.location = location;
	}

	/**
	 * @return the jobTitle
	 */
	public List<JobTitle> getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(List<JobTitle> jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the mode
	 */
	public List<Mode> getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(List<Mode> mode) {
		this.mode = mode;
	}

	/**
	 * @return the payType
	 */
	public List<PayType> getPayType() {
		return payType;
	}

	/**
	 * @param payType the payType to set
	 */
	public void setPayType(List<PayType> payType) {
		this.payType = payType;
	}

	/**
	 * @return the employer
	 */
	public List<Employer> getEmployer() {
		return employer;
	}

	/**
	 * @param employer the employer to set
	 */
	public void setEmployer(List<Employer> employer) {
		this.employer = employer;
	}

	/**
	 * @return the domainList
	 */
	public List<ClientDomain> getDomainList() {
		return domainList;
	}

	/**
	 * @param domainList the domainList to set
	 */
	public void setDomainList(List<ClientDomain> domainList) {
		this.domainList = domainList;
	}

	/**
	 * @return the endClient
	 */
	public List<EndClient> getEndClient() {
		return endClient;
	}

	/**
	 * @param endClient the endClient to set
	 */
	public void setEndClient(List<EndClient> endClient) {
		this.endClient = endClient;
	}

	/**
	 * @return the primeVendor
	 */
	public List<PrimeVendor> getPrimeVendor() {
		return primeVendor;
	}

	/**
	 * @param primeVendor the primeVendor to set
	 */
	public void setPrimeVendor(List<PrimeVendor> primeVendor) {
		this.primeVendor = primeVendor;
	}
	
	
	
}
