package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.Status;
import com.edms.core.repository.StatusRepository;
import com.edms.core.service.StatusService;
@Service
@Transactional
public class StatusServiceImpl implements StatusService {
	
	private final Logger log = LoggerFactory.getLogger(StatusServiceImpl.class);

 	@Autowired
    private StatusRepository statusRepository;

	@Override
	public Status save(Status status) {
		log.debug("Request to save Status : {}", status);
        return statusRepository.save(status);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<Status> findAll() {
		log.debug("Request to get all Status : {}");
		return statusRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Status> findOne(Long id) {
		log.debug("Request to get Status based on Id: {}");
		return statusRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Status : {}", id);
		statusRepository.deleteById(id);
	}
}
