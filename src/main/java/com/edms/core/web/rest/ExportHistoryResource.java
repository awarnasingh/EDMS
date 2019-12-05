package com.edms.core.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edms.core.domain.ExportHistory;
import com.edms.core.service.ExportHistoryService;

@RestController
@RequestMapping("/api")
public class ExportHistoryResource {

	private final Logger log = LoggerFactory.getLogger(SearchHistoryResource.class);

    @Autowired
    private ExportHistoryService exportHistoryService;
    
    /**
     * {@code GET  /export-histories} : get all the ExportHistory by user_id and exportDownload.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ExportHistory in body.
     */
    @GetMapping("/export-histories/download/{userName}")
    public List<ExportHistory> getExportHistoriesByDownload(@PathVariable String userName) {
        log.debug("REST request to get all ExportHistory based on userid and download status");
        
        return exportHistoryService.findExportHistoryByUserIdAndDownloadStatus(userName);
    }

    /**
     * {@code GET  /export-histories} : get all the ExportHistory by user_id and exportMail.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ExportHistory in body.
     */
    @GetMapping("/export-histories/mail/{userName}")
    public List<ExportHistory> getExportHistoriesByMail(@PathVariable String userName) {
        log.debug("REST request to get all ExportHistory based on userid and mail-status");
        
        return exportHistoryService.findExportHistoryByUserIdAndMailStatus(userName);
    }

}
