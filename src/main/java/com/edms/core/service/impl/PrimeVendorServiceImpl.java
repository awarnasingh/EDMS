package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.PrimeVendor;
import com.edms.core.repository.PrimeVendorRepository;
import com.edms.core.service.PrimeVendorService;
@Service
@Transactional
public class PrimeVendorServiceImpl implements PrimeVendorService {

private final Logger log = LoggerFactory.getLogger(PrimeVendorServiceImpl.class);
 	
 	@Autowired
    private PrimeVendorRepository primeVendorRepository;

	@Override
	public PrimeVendor save(PrimeVendor primeVendor) {
		log.debug("Request to save PrimeVendor : {}", primeVendor);
        return primeVendorRepository.save(primeVendor);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<PrimeVendor> findAll() {
		log.debug("Request to get all primeVendor : {}");
		return primeVendorRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<PrimeVendor> findOne(Long id) {
		log.debug("Request to get PrimeVendor based on Id: {}");
		return primeVendorRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete PrimeVendor : {}", id);
		primeVendorRepository.deleteById(id);
	}
}
