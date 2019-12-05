package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.WorkAuthorization;
import com.edms.core.repository.WorkAuthorizationRepository;
import com.edms.core.service.WorkAuthorizationService;
@Service
@Transactional
public class WorkAuthorizationServiceImpl implements WorkAuthorizationService{
	
	private final Logger log = LoggerFactory.getLogger(WorkAuthorizationServiceImpl.class);

 	@Autowired
    private WorkAuthorizationRepository authorizationRepository;

	@Override
	public WorkAuthorization save(WorkAuthorization workAuthorization) {
		log.debug("Request to save WorkAuthorization : {}", workAuthorization);
        return authorizationRepository.save(workAuthorization);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<WorkAuthorization> findAll() {
		log.debug("Request to get all WorkAuthorization : {}");
		return authorizationRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<WorkAuthorization> findOne(Long id) {
		log.debug("Request to get WorkAuthorization based on Id: {}");
		return authorizationRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete WorkAuthorization : {}", id);
		authorizationRepository.deleteById(id);
	}
}
