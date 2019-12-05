package com.edms.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.Professional;
import com.edms.core.domain.ProfessionalHistory;
import com.edms.core.repository.ProfessionalHistoryRepository;
@Service
@Transactional
public class ProfessionalHistoryServiceImpl {
	@Autowired
	private  ProfessionalHistoryRepository professionalHistoryRepository;

	public void save(Professional professional) {
		ProfessionalHistory professionalHistory=new ProfessionalHistory();
	
		professionalHistory.setProfessionalId(professional.getId());
		professionalHistory.setEmpType(professional.getEmployee().getEmpType().getName());
		professionalHistory.setSrsEmpId(professional.getEmployee().getSrsEmpId());
		professionalHistory.setFullName(professional.getEmployee().getFullName());
		professionalHistory.setFirstName(professional.getEmployee().getFirstName());
		professionalHistory.setLastName(professional.getEmployee().getLastName());
		professionalHistory.setEducation(professional.getEmployee().getEducation());
		professionalHistory.setCertification(professional.getEmployee().getCertification());
		professionalHistory.setEmail(professional.getEmployee().getEmail());
		professionalHistory.setHomePhone(professional.getEmployee().getHomePhone());
		professionalHistory.setMobileNumber(professional.getEmployee().getMobileNumber());
		professionalHistory.setWorkPhoneNumber(professional.getEmployee().getWorkPhoneNumber());
		professionalHistory.setdOB(professional.getEmployee().getDOB());
		professionalHistory.setStatus(professional.getEmployee().getStatus().getName());
		
		professionalHistory.setCity(professional.getCity());
		professionalHistory.setLocation(professional.getLocation().getName());
		professionalHistory.setTotalExperience(professional.getTotalExperience());
		professionalHistory.setJobTitle(professional.getJobTitle().getName());		
		professionalHistory.setTypeOfRole(professional.getTypeOfRole());
		professionalHistory.setSkillCategory(professional.getSkillCategory());
		professionalHistory.setSpecificSkills(professional.getSpecificSkills());
		professionalHistory.setGeneralSkills(professional.getGeneralSkills());
		professionalHistory.setClientDomain(professional.getClientDomain().getName());
		professionalHistory.setMode(professional.getMode().getName());
		professionalHistory.setEmployer(professional.getEmployer().getName());
		professionalHistory.setPrimeVendor(professional.getPrimeVendor().getName());
		professionalHistory.setEndClient(professional.getEndClient().getName());
		professionalHistory.setCurrentProjectStartDate(professional.getCurrentProjectStartDate());
		professionalHistory.setCurrentProjectEndDate(professional.getCurrentProjectEndDate());
		professionalHistory.setRemarks(professional.getRemarks());
		professionalHistory.setSellRate(professional.getSellRate());
		professionalHistory.setWorkAuthorization(professional.getWorkAuthorization().getName());
		professionalHistory.setAddedOn(professional.getAddedOn());
		professionalHistory.setBenchAge(professional.getBenchAge());
		professionalHistory.setTechnology(professional.getTechnology());
		professionalHistory.setPayType(professional.getPayType().getName());
		professionalHistory.setAdditionalNotifiers(professional.getAdditionalNotifiers());
		professionalHistory.setSource(professional.getSource());
		professionalHistory.setWorkExperience(professional.getWorkExperience());
		professionalHistory.setPrimarySkills(professional.getPrimarySkills());
		professionalHistory.setSellRateHelper(professional.getSellRateHelper());
		professionalHistory.setCreatedBy(professional.getCreatedBy());
		professionalHistory.setCreatedDate(professional.getCreatedDate());
		professionalHistory.setUpdatedBy(professional.getUpdatedBy());
		professionalHistory.setUpdatedDate(professional.getUpdatedDate());
		
		professionalHistory.setLayerOne(professional.getLayerOne());
		professionalHistory.setLayerTwo(professional.getLayerTwo());
		professionalHistory.setLayerThree(professional.getLayerThree());
		professionalHistory.setLayerFour(professional.getLayerFour());
		professionalHistory.setSrsJoiningDate(professional.getSrsJoiningDate());



		professionalHistoryRepository.save(professionalHistory);
	}
	
	}
