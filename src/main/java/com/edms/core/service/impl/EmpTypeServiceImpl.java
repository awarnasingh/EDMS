package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.EmpType;
import com.edms.core.repository.EmpTypeRepository;
import com.edms.core.service.EmpTypeService;
@Service
@Transactional
public class EmpTypeServiceImpl implements EmpTypeService {
	
	private final Logger log = LoggerFactory.getLogger(EmpTypeServiceImpl.class);

 	@Autowired
    private EmpTypeRepository empTypeRepository;

	@Override
	public EmpType save(EmpType empType) {
		log.debug("Request to save EmpType : {}", empType);
        return empTypeRepository.save(empType);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<EmpType> findAll() {
		log.debug("Request to get all EmpType : {}");
		return empTypeRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<EmpType> findOne(Long id) {
		log.debug("Request to get EmpType based on Id: {}");
		return empTypeRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete EmpType : {}", id);
		empTypeRepository.deleteById(id);
	}
}
