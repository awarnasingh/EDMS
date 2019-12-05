package com.edms.core.service;

import java.util.List;

import com.edms.core.domain.ExportHistory;

public interface ExportHistoryService {


	List<ExportHistory> findExportHistoryByUserIdAndMailStatus(String userName);

	List<ExportHistory> findExportHistoryByUserIdAndDownloadStatus(String userName);

}
