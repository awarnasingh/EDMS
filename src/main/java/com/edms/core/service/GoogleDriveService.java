package com.edms.core.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.edms.core.constants.ConstantUtils;
import com.edms.core.security.GoogleDriveConfig;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

@Service
public class GoogleDriveService {
	
	private final Logger log = LoggerFactory.getLogger(GoogleDriveService.class);
	GoogleDriveConfig config = new GoogleDriveConfig();
	
	// Build a new authorized API client service.
	public void startGoogleDrive() throws IOException, GeneralSecurityException {
		log.info(ConstantUtils.STARTING_GOOGLE_DRIVE);
		String folderId = ConstantUtils.GOOGLE_ID;
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    Drive service = new Drive.Builder(HTTP_TRANSPORT, GoogleDriveConfig.JSON_FACTORY, config.getCredentials(HTTP_TRANSPORT))
            .setApplicationName(GoogleDriveConfig.APPLICATION_NAME)
            .build();
    Process p = null;
    try {
    	log.info("sql backup command running");
        Runtime runtime = Runtime.getRuntime();
        p = runtime.exec("mysqldump -uroot -proot --add-drop-database -B edms -r " + "backup/" + "backup_"+LocalDate.now().toString()+".sql");
        int processComplete = p.waitFor();

        if (processComplete == 0) {

        	log.info("Backup created successfully");
        	log.info("started uploading backup file");
            File fileMetadata = new File();
            
            fileMetadata.setName( LocalDateTime.now().format(DateTimeFormatter.ofPattern(ConstantUtils.DD_MM_YYYY_HH_MM)).toString()+"_backup").setParents(Collections.singletonList(folderId));
            java.io.File filePath = new java.io.File("backup/backup_"+LocalDate.now().toString()+ConstantUtils.SQL);
            FileContent mediaContent = new FileContent(ConstantUtils.APPLICATION_SQL, filePath);
            File file = service.files().create(fileMetadata, mediaContent)
            		.setFields(ConstantUtils.ID).execute();
            System.out.println(ConstantUtils.FILE_ID + file.getId());
            filePath.delete();
        } else {
        	log.error("error while creating sql backup");
        }


    } catch (Exception e) {
        e.printStackTrace();
    }
}
	
	@Scheduled(cron = "0 59 23 * * *")
	public void backupDB() throws IOException, GeneralSecurityException {
		log.info("schedule backup started"+ LocalDateTime.now().toString());
		startGoogleDrive();
	}
	
}
