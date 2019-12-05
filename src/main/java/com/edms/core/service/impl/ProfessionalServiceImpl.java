package com.edms.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.edms.core.security.SecurityUtils;

import com.edms.core.service.ProfessionalService;
import com.edms.core.web.rest.vm.SearchVm;
import com.edms.core.domain.Professional;
import com.edms.core.repository.ProfessionalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service Implementation for managing {@link Professional}.
 */

/**
 * @author anurag
 */
@Service
@Transactional
public class ProfessionalServiceImpl implements ProfessionalService {

    private final Logger log = LoggerFactory.getLogger(ProfessionalServiceImpl.class);

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProfessionalHistoryServiceImpl professionalHistoryServiceImpl;

    /**
     * Save a professional.
     *
     * @param professional the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Professional save(Professional professional) {
        log.debug("Request to save Professional : {}", professional);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String user = SecurityUtils.getCurrentUserLogin().get();

        if (professional.getId() == null) {
            professional.setCreatedBy(user);
            professional.setCreatedDate(localDate);
            professional.getEmployee().setCreatedBy(user);
            professional.getEmployee().setCreatedDate(localDate);
        } else {
            professional.setUpdatedBy(user);
            professional.setUpdatedDate(localDate);
            professional.getEmployee().setUpdatedBy(user);
            professional.getEmployee().setUpdatedDate(localDate);

            // save updated history
            professionalHistoryServiceImpl.save(professional);
        }

        return professionalRepository.save(professional);
    }

    /**
     * Get all the professionals.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Professional> findAll() {
        log.debug("Request to get all Professionals");
        return professionalRepository.findAll();
    }


    /**
     * Get one professional by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Professional> findOne(Long id) {
        log.debug("Request to get Professional : {}", id);
        return professionalRepository.findById(id);
    }

    /**
     * Delete the professional by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Professional : {}", id);
        professionalRepository.deleteById(id);
    }

    /**
     * search professional based on createria
     *
     * @param SearchVm returns list of professional
     */
    @Override
    public List<Professional> searchAll(SearchVm searchVm) {
        log.debug("REST request to search employees based on " + searchVm);
        List<Professional> proList;
        proList = professionalRepository.searchAll(searchVm.getLocation(), searchVm.getExpStart(), searchVm.getExpEnd(),
                searchVm.getDomain(), searchVm.getType(), searchVm.getStatus(), searchVm.getEndClient(), null, null);
        log.info(searchVm.getSkills() + searchVm.getFullName());
        proList = doFilter(proList, searchVm.getSkills(), searchVm.getFullName() == null ? searchVm.getFullName() : searchVm.getFullName().trim());
        return proList;
    }


    /**
     * filtering the professional list based on name and skills
     *
     * @param proList
     * @param skills
     * @param name
     * @return list of professional
     */
    private List<Professional> doFilter(List<Professional> proList, String skills, String name) {
        Set<Professional> professionalList = new HashSet<Professional>();
        List<String> skillList = new ArrayList<String>();
        List<String> nameList = new ArrayList<String>();
        if (!(isNullOrEmpty(skills)))
            skillList = Arrays.asList(skills.split(","));
        if (!(isNullOrEmpty(name)))
            nameList = Arrays.asList(name.split(","));
        log.info("filtering started");
        if ((!(isNullOrEmpty(name))) && (!(isNullOrEmpty(skills)))) {
            for (int i = 0; i < skillList.size(); i++) {
                for (Professional p : proList) {
                    if (isContainExactWord(p.getSpecificSkills() == null ? "" : p.getSpecificSkills().toLowerCase(), skillList.get(i).toLowerCase())
                            || isContainExactWord(p.getGeneralSkills() == null ? "" : p.getGeneralSkills().toLowerCase(), skillList.get(i).toLowerCase())
                            || isContainExactWord(p.getJobTitle().getName() == null ? "" : p.getJobTitle().getName().toLowerCase(), skillList.get(i).toLowerCase())
                            || isContainExactWord(p.getPrimarySkills() == null ? "" : p.getPrimarySkills().toLowerCase(), skillList.get(i).toLowerCase())) {
                        if (nameList.size() > i) {
                            if (isContainExactWord(p.getEmployee().getFullName().toLowerCase(),
                                    nameList.get(i).toLowerCase())) {
                                professionalList.add(p);
                            }
                        }
                    }
                }
            }
            return new ArrayList<Professional>(professionalList);
        } else if (!(isNullOrEmpty(name))) {
            for (int i = 0; i < nameList.size(); i++) {
                for (Professional p : proList) {
                    if (isContainExactWord(p.getEmployee().getFullName().toLowerCase(),
                            nameList.get(i).toLowerCase())) {

                        professionalList.add(p);
                    }
                }
            }
            return new ArrayList<Professional>(professionalList);
        } else if (!(isNullOrEmpty(skills))) {
            for (int i = 0; i < skillList.size(); i++) {
                for (Professional p : proList) {
                    if (isContainExactWord(p.getSpecificSkills() == null ? "" : p.getSpecificSkills().toLowerCase(), skillList.get(i).toLowerCase())
                            || isContainExactWord(p.getGeneralSkills() == null ? "" : p.getGeneralSkills().toLowerCase(), skillList.get(i).toLowerCase())
                            || isContainExactWord(p.getJobTitle().getName() == null ? "" : p.getJobTitle().getName().toLowerCase(), skillList.get(i).toLowerCase())
                            || isContainExactWord(p.getPrimarySkills() == null ? "" : p.getPrimarySkills().toLowerCase(), skillList.get(i).toLowerCase())) {
                        professionalList.add(p);
                    }
                }
            }
            return new ArrayList<Professional>(professionalList);
        } else {
            return proList;
        }
    }

    /**
     * @param fullString
     * @param partWord
     * @return boolean
     */
    private boolean isContainExactWord(String fullString, String partWord) {
        String pattern = "\\b" + partWord + "\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(fullString);
        return m.find();
    }

    /**
     * @param str
     * @return boolean
     */
    public boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty())
            return false;
        return true;
    }

    /**
     * schedular for update employee experience
     */
    @Scheduled(cron = "0 0 0 1 1/1 *")
    public void updateEmpTotalExperience() {
        int count = 0;
        List<Professional> professionalsList = findAll();
        log.info("running scheduled job for updating experience");
        for (Professional prof : professionalsList) {
            LocalDate now = LocalDate.now();
            if (prof.getUpdatedDate() != null) {
                Period diff = Period.between(prof.getUpdatedDate(), now);
                Double years = Double.valueOf(diff.getYears() + "." + diff.getMonths());
                prof.setTotalExperience(prof.getTotalExperience() + years);
                prof.setUpdatedDate(now);
                prof.setUpdatedBy("System");
                professionalRepository.save(prof);
                count++;
            }
        }
        log.info("Total record updated  :: " + count);
    }

}
