package com.edms.core.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.ExportHistory;
import com.edms.core.repository.ClientDomainRepository;
import com.edms.core.repository.EmpTypeRepository;
import com.edms.core.repository.EndClientRepository;
import com.edms.core.repository.ExportHistoryRepository;
import com.edms.core.repository.LocationRepository;
import com.edms.core.repository.StatusRepository;
import com.edms.core.security.SecurityUtils;
import com.edms.core.service.ExportHistoryService;
import com.edms.core.web.rest.vm.SearchVm;

@Service
@Transactional
public class ExportHistoryServiceImpl implements ExportHistoryService {

    private final Logger log = LoggerFactory.getLogger(ExportHistoryServiceImpl.class);

	@Autowired
    private ExportHistoryRepository exportHistoryRepository;

    @Autowired
    private EmpTypeRepository empTypeRepository;

    @Autowired
    private ClientDomainRepository clientDomainRepository;
    
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private EndClientRepository endClientRepository;

    
    @Override
    public List<ExportHistory> findExportHistoryByUserIdAndDownloadStatus(String userName) {
        return exportHistoryRepository.findExportHistoryByUserIdAndDownloadStatus(userName, true);
    }

    @Override
    public List<ExportHistory> findExportHistoryByUserIdAndMailStatus(String userName) {
        return exportHistoryRepository.findExportHistoryByUserIdAndMailStatus(userName, true);
    }

    public void save(SearchVm searchVm, int size, Boolean downloaded, Boolean mailed) {
        ExportHistory eHistory = new ExportHistory();
        eHistory.setUserID(SecurityUtils.getCurrentUserLogin().get());
        eHistory.setExportDate(LocalDateTime.now());
        eHistory.setExportDownload(downloaded);
        eHistory.setExportMail(mailed);
        eHistory.setRowCount(size);
        eHistory.setEmpType((null == searchVm.getType() ) ? null: empTypeRepository.findByID(searchVm.getType()));
        eHistory.setDomain((null == searchVm.getDomain()) ? null:clientDomainRepository.findByID(searchVm.getDomain()));
        eHistory.setFromExperience(searchVm.getExpStart());
        eHistory.setToExperience(searchVm.getExpEnd());
        eHistory.setLocation(( null == searchVm.getLocation()) ? null:locationRepository.findByID(searchVm.getLocation()));
        eHistory.setStatus(( null == searchVm.getStatus()) ? null:statusRepository.findByID(searchVm.getStatus()));
        eHistory.setEndClient((null == searchVm.getEndClient()) ? null:endClientRepository.findByID(searchVm.getEndClient()));
        eHistory.setSkills(searchVm.getSkills());
        log.info("************searchVm.getFullName()_____:::"+searchVm.getFullName());
        eHistory.setEmployeeName(searchVm.getFullName());

        exportHistoryRepository.save(eHistory);
    }

}
