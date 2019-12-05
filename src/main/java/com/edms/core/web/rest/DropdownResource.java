package com.edms.core.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edms.core.domain.Configuration;
import com.edms.core.service.DropdownService;



/**
 * @author avishwak
 * returns dropdown fields value 
 */
@RestController
@RequestMapping("/api")
public class DropdownResource {
	
	@Autowired
	DropdownService dropdownService;

	/**
	 * @return dropdowns  
	 */
	@GetMapping("/dropdowns")
	public Configuration getDropdowns(){
		Configuration configuration = dropdownService.getDropdowns();
		return configuration;
 }
	

}
