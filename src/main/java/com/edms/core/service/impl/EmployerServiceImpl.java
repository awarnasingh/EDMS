package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.Employer;
import com.edms.core.repository.EmployerRepository;
import com.edms.core.service.EmployerService;
@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {
	
	private final Logger log = LoggerFactory.getLogger(ClientDomainServiceImpl.class);

 	@Autowired
    private EmployerRepository employerRepository;

	@Override
	public Employer save(Employer employer) {
		log.debug("Request to save Employer : {}", employer);
        return employerRepository.save(employer);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<Employer> findAll() {
		log.debug("Request to get all Employer : {}");
		return employerRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Employer> findOne(Long id) {
		log.debug("Request to get Employer based on Id: {}");
		return employerRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Employer : {}", id);
		employerRepository.deleteById(id);
	}
}
