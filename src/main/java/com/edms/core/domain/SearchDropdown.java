package com.edms.core.domain;

import java.util.Map;

public class SearchDropdown {

    Map<Integer, String> domainList;
    Map<Integer, String> location;
    Map<Integer, String> status;
    Map<Integer, String> endClient;
    Map<Integer, String> empType;
    Map<Integer, String> mode;
    Map<Integer, String> employer;
    Map<Integer, String> primeVendor;

    public Map<Integer, String> getDomainList() {
        return domainList;
    }

    public void setDomainList(Map<Integer, String> domainList) {
        this.domainList = domainList;
    }

    public Map<Integer, String> getLocation() {
        return location;
    }

    public void setLocation(Map<Integer, String> location) {
        this.location = location;
    }

    public Map<Integer, String> getStatus() {
        return status;
    }

    public void setStatus(Map<Integer, String> status) {
        this.status = status;
    }

    public Map<Integer, String> getEndClient() {
        return endClient;
    }

    public void setEndClient(Map<Integer, String> endClient) {
        this.endClient = endClient;
    }

    public Map<Integer, String> getEmpType() {
        return empType;
    }

    public void setEmpType(Map<Integer, String> empType) {
        this.empType = empType;
    }

    public Map<Integer, String> getMode() {
        return mode;
    }

    public void setMode(Map<Integer, String> mode) {
        this.mode = mode;
    }

    public Map<Integer, String> getEmployer() {
        return employer;
    }

    public void setEmployer(Map<Integer, String> employer) {
        this.employer = employer;
    }

    public Map<Integer, String> getPrimeVendor() {
        return primeVendor;
    }

    public void setPrimeVendor(Map<Integer, String> primeVendor) {
        this.primeVendor = primeVendor;
    }


    @Override
    public String toString() {
        return "SearchDropdown{" +
                "domainList=" + domainList +
                ", location=" + location +
                ", status=" + status +
                ", endClient=" + endClient +
                ", empType=" + empType +
                ", mode=" + mode +
                ", employer=" + employer +
                ", primeVendor=" + primeVendor +
                '}';
    }
}
