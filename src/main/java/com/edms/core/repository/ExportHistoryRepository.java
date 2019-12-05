package com.edms.core.repository;

import com.edms.core.domain.ExportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportHistoryRepository extends JpaRepository<ExportHistory, Long> {

    @Query(value = "select * from edms.export_history where user_id = :userId and export_download= :exportDownload ", nativeQuery = true)
    List<ExportHistory> findExportHistoryByUserIdAndDownloadStatus(@Param("userId") String userId, @Param("exportDownload") Boolean exportDownload);

    @Query(value = "select * from edms.export_history where user_id = :userId and export_mail= :exportMail ", nativeQuery = true)
    List<ExportHistory> findExportHistoryByUserIdAndMailStatus(@Param("userId") String userId, @Param("exportMail") Boolean exportMail);

}
