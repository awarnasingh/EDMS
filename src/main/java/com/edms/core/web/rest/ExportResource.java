package com.edms.core.web.rest;

import java.io.ByteArrayInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edms.core.constants.ConstantUtils;
import com.edms.core.service.ExportService;
import com.edms.core.service.MailService;
import com.edms.core.service.UserService;
import com.edms.core.web.rest.vm.ExcelVm;
import com.edms.core.web.rest.vm.Inventory;

/**
 * @author anurag
 *
 */
@RestController
@RequestMapping("/api")
public class ExportResource {
	
	private final Logger log = LoggerFactory.getLogger(ExportResource.class);
	
	@Autowired
	ExportService exportService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	
	
	/**
	 * @param idList
	 * @returns InputStreamResource 
	 * Excel with employee details based on  employee Ids
	 */
	@PostMapping("/downloadReport")
	public ResponseEntity<InputStreamResource> getselectedRecordsInExcel(@RequestBody Inventory idList) {
		log.debug("REST request to get employee Excel based on IDs" + idList.getId());
		ByteArrayInputStream in = exportService.getRecordsInExcel(idList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(ConstantUtils.CONTENT_TYPE, ConstantUtils.APPLICATION_VND_MSEXCEL);
		return (ResponseEntity<InputStreamResource>) ResponseEntity.ok()
				.header(ConstantUtils.CONTENT_TYPE, ConstantUtils.APPLICATION_VND_MSEXCEL).body(new InputStreamResource(in));
	}


	 /**
	 * @param excelVm
	 * @return InputStreamResource 
	 * Excel with employee details based on search createria
	 */
	@PostMapping("/downloadExcel")
	    public ResponseEntity<InputStreamResource> getRecordsInExcel(@RequestBody ExcelVm excelVm){
	    	log.debug("REST request to get employee Excel for all the employee");
	    	ByteArrayInputStream in = exportService.getRecordsInExcel(excelVm.getSearchVm(),excelVm.getColunm());
	    	 HttpHeaders responseHeaders = new HttpHeaders();
	    	    responseHeaders.set(ConstantUtils.CONTENT_TYPE, 
	    	    		ConstantUtils.APPLICATION_VND_MSEXCEL);
	    	return (ResponseEntity<InputStreamResource>) ResponseEntity
					.ok().header(ConstantUtils.CONTENT_TYPE, 
							ConstantUtils.APPLICATION_VND_MSEXCEL).body(new InputStreamResource(in));
	    }
	    
	    /**
	     * @param excelVm
	     * @return excel response in mail
	     * 
	     */
	    @PostMapping("/mail")
	    public ResponseEntity<?> sendReportsasMail(@RequestBody ExcelVm excelVm){
	    	log.debug("REST request to Export Results as Mail" );
				return exportService.getRecordsInExcelForMail(excelVm.getSearchVm(),excelVm.getColunm());
	    		    	
	    }

}
