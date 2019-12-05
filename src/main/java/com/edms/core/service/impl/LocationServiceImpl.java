package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.Location;
import com.edms.core.repository.LocationRepository;
import com.edms.core.service.LocationService;
@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	private final Logger log = LoggerFactory.getLogger(LocationServiceImpl.class);

 	@Autowired
    private LocationRepository locationRepository;

	@Override
	public Location save(Location location) {
		log.debug("Request to save Location : {}", location);
        return locationRepository.save(location);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<Location> findAll() {
		log.debug("Request to get all Location : {}");
		return locationRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Location> findOne(Long id) {
		log.debug("Request to get Location based on Id: {}");
		return locationRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Location : {}", id);
		locationRepository.deleteById(id);
	}
}
