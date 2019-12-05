package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.JobTitle;
import com.edms.core.repository.JobTitleRepository;
import com.edms.core.service.JobTitleService;
@Service
@Transactional
public class JobTitleServiceImpl implements JobTitleService {

private final Logger log = LoggerFactory.getLogger(JobTitleServiceImpl.class);
 	
 	@Autowired
    private JobTitleRepository jobTitleRepository;

	@Override
	public JobTitle save(JobTitle jobTitle) {
		log.debug("Request to save JobTitle : {}", jobTitle);
        return jobTitleRepository.save(jobTitle);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<JobTitle> findAll() {
		log.debug("Request to get all EndClient : {}");
		return jobTitleRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<JobTitle> findOne(Long id) {
		log.debug("Request to get JobTitle based on Id: {}");
		return jobTitleRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete JobTitle : {}", id);
		jobTitleRepository.deleteById(id);
	}
}
