package com.edms.core.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edms.core.domain.Charts;
import com.edms.core.service.EmpStatusService;

/**
 * @author anurag
 *
 */
@RestController
@RequestMapping("/api")
public class EmpStatusResource {
	private final Logger log = LoggerFactory.getLogger(ProfessionalResource.class);
	@Autowired
	EmpStatusService empStatusService;
	
	
	/**
	 * @returns response with data requires for the dashbord chart 
	 */
	@GetMapping("/statusDetails")
	   public List<Charts> getEmpStstus(){
		   log.debug("REST request to Get Status i.e, No.of employess active/bench/exit");
		   
		  return empStatusService.getEmpStatus();
		
	   }
}
