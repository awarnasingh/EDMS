package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.EndClient;
import com.edms.core.repository.EndClientRepository;
import com.edms.core.service.EndClientService;
@Service
@Transactional
public class EndClientServiceImpl implements EndClientService {

	private final Logger log = LoggerFactory.getLogger(EndClientServiceImpl.class);
 	
 	@Autowired
    private EndClientRepository endClientRepository;

	@Override
	public EndClient save(EndClient endClient) {
		log.debug("Request to save EndClient : {}", endClient);
        return endClientRepository.save(endClient);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<EndClient> findAll() {
		log.debug("Request to get all EndClient : {}");
		return endClientRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<EndClient> findOne(Long id) {
		log.debug("Request to get EndClient based on Id: {}");
		return endClientRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete EndClient : {}", id);
		endClientRepository.deleteById(id);
	}

}
