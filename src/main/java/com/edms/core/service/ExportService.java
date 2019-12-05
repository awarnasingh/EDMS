package com.edms.core.service;

import java.io.ByteArrayInputStream;

import org.springframework.http.ResponseEntity;

import com.edms.core.domain.Colunm;
import com.edms.core.web.rest.vm.Inventory;
import com.edms.core.web.rest.vm.SearchVm;

public interface ExportService {
	
	  ByteArrayInputStream getRecordsInExcel(SearchVm searchVm,Colunm colunm);
	    
	  ByteArrayInputStream getRecordsInExcel(Inventory idList);

	  ResponseEntity<?> getRecordsInExcelForMail(SearchVm searchVm, Colunm colunm);
}	