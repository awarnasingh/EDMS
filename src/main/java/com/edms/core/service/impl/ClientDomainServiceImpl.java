package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.ClientDomain;
import com.edms.core.repository.ClientDomainRepository;
import com.edms.core.service.ClientDomainService;
@Service
@Transactional
public class ClientDomainServiceImpl implements ClientDomainService {
	
	private final Logger log = LoggerFactory.getLogger(ClientDomainServiceImpl.class);

 	@Autowired
    private ClientDomainRepository clientDomainRepository;

	@Override
	public ClientDomain save(ClientDomain clientDomain) {
		log.debug("Request to save WorkAuthorization : {}", clientDomain);
        return clientDomainRepository.save(clientDomain);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<ClientDomain> findAll() {
		log.debug("Request to get all ClientDomain : {}");
		return clientDomainRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<ClientDomain> findOne(Long id) {
		log.debug("Request to get ClientDomain based on Id: {}");
		return clientDomainRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete ClientDomain : {}", id);
		clientDomainRepository.deleteById(id);
	}
}
