package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.Mode;
import com.edms.core.repository.ModeRepository;
import com.edms.core.service.ModeService;
@Service
@Transactional
public class ModeServiceImpl implements ModeService {
	
	private final Logger log = LoggerFactory.getLogger(ModeServiceImpl.class);

 	@Autowired
    private ModeRepository modeRepository;

	@Override
	public Mode save(Mode mode) {
		log.debug("Request to save Mode : {}", mode);
        return modeRepository.save(mode);
	}

	@Override
	 @Transactional(readOnly = true)
	public List<Mode> findAll() {
		log.debug("Request to get all Modes : {}");
		return modeRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Mode> findOne(Long id) {
		log.debug("Request to get Mode based on Id: {}");
		return modeRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		log.debug("Request to delete Mode : {}", id);
		modeRepository.deleteById(id);
	}
}
