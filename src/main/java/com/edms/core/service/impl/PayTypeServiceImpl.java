package com.edms.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.PayType;
import com.edms.core.repository.PayTypeRepository;
import com.edms.core.service.PayTypeService;

@Service
@Transactional
public class PayTypeServiceImpl implements PayTypeService {
	
	 private final Logger log = LoggerFactory.getLogger(PayTypeServiceImpl.class);
	 	
	 	@Autowired
	    private PayTypeRepository payTypeRepository;

		@Override
		public PayType save(PayType payType) {
			log.debug("Request to save PayType : {}", payType);
            return payTypeRepository.save(payType);
		}

		@Override
		 @Transactional(readOnly = true)
		public List<PayType> findAll() {
			log.debug("Request to get all PayType : {}");
			return payTypeRepository.findAll();
		}

		@Override
		@Transactional
		public Optional<PayType> findOne(Long id) {
			log.debug("Request to get PayType based on Id: {}");
			return payTypeRepository.findById(id);
		}

		@Override
		public void delete(Long id) {
			log.debug("Request to delete PayType : {}", id);
			payTypeRepository.deleteById(id);
		}
}
