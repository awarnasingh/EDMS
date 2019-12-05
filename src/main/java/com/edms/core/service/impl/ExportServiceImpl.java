package com.edms.core.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edms.core.constants.ConstantUtils;
import com.edms.core.domain.Colunm;
import com.edms.core.domain.Professional;
import com.edms.core.service.ExportService;
import com.edms.core.service.MailService;
import com.edms.core.service.ProfessionalService;
import com.edms.core.service.UserService;
import com.edms.core.web.rest.vm.Inventory;
import com.edms.core.web.rest.vm.SearchVm;

/**
 * @author anurag
 */
@Service
public class ExportServiceImpl implements ExportService {

    private final Logger log = LoggerFactory.getLogger(ExportServiceImpl.class);

    @Autowired
    ProfessionalService professionalService;
    @Autowired
    ExportHistoryServiceImpl exportHistoryServiceImpl;
    @Autowired
    UserService userService;
    @Autowired
    MailService mailService;

    /**
     * returns ByteArrayInputStream
     */
    @Override
    public ByteArrayInputStream getRecordsInExcel(SearchVm searchVm, Colunm colunm) {

        log.debug("REST request to get employee Excel for all the employee");

        List<Professional> proList = professionalService.searchAll(searchVm);
        /**
         * Added To track download history
         */
        exportHistoryServiceImpl.save(searchVm, proList.size(), true, false);

        return employeeToExcel(proList, colunm);

    }

    @Override
    public ResponseEntity<?> getRecordsInExcelForMail(SearchVm searchVm, Colunm colunm) {

        log.debug("REST request to get employee Excel for all the employee");

        List<Professional> proList = professionalService.searchAll(searchVm);

        String to = userService.getUserWithAuthorities().get().getEmail();
        ByteArrayInputStream in = employeeToExcel(proList, colunm);
        log.info("=========Mail address to send mail==============:::"+to);
        if (to != null && to.contains(ConstantUtils.SRS_CONSULTING_MAIL)) {

            mailService.sendReportsToEmail(to, in);
            /**
             * Added To track Mail history
             */
            exportHistoryServiceImpl.save(searchVm, proList.size(), false, true);
            return new ResponseEntity<>(ConstantUtils.MAIL_SEND_SUCCESS_MSG, HttpStatus.OK);
        }
        return new ResponseEntity<>(ConstantUtils.UNABLE_SEND_MAIL, HttpStatus.BAD_REQUEST);

    }

    @Override
    public ByteArrayInputStream getRecordsInExcel(Inventory idList) {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * @param professionals
     * @param colunm
     * @return ByteArrayInputStream
     * this will create the excel based on same condition
     */
    public ByteArrayInputStream employeeToExcel(List<Professional> professionals, Colunm colunm) {
        int count = 0;
        String[] COLUMNs = createColunm(colunm);
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet(ConstantUtils.EMPLOYEE_DETAILS);
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        log.debug("employee Excel generation started");
        // Row for Header
        Row headerRow = sheet.createRow(0);

        for (int col = 0; col < COLUMNs.length; col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(COLUMNs[col]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowIdx = 1;
        for (Professional pro : professionals) {
            Row row = sheet.createRow(rowIdx++);
            // if(colunm.getId())
            row.createCell(count).setCellValue(pro.getEmployee().getId());
            if (colunm.getEmpType()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getEmpType().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getEmpType().getName());
            }
            if (colunm.getSrsEmpId()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getSrsEmpId() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getSrsEmpId());
            }
            if (colunm.getFullName()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getFullName() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getFullName());
            }
            if (colunm.getFirstName()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getFirstName() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getFirstName());
            }
            if (colunm.getLastName()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getLastName() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getLastName());
            }
            if (colunm.getStatus()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getStatus() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getStatus().getName());
            }
            if (colunm.getLocation()) {
                count++;
                row.createCell(count).setCellValue(pro.getLocation().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getLocation().getName());
            }
            if (colunm.getTotalExperience()) {
                count++;
                row.createCell(count).setCellValue(pro.getTotalExperience() == null ? 0 : pro.getTotalExperience());
            }
            if (colunm.getEducation()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getEducation() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getEducation());
            }
            if (colunm.getTitle()) {
                count++;
                row.createCell(count).setCellValue(pro.getJobTitle().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getJobTitle().getName());
            }
            if (colunm.getCertification()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getEmployee().getCertification() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getCertification());
            }
            if (colunm.getSkillCategory()) {
                count++;
                row.createCell(count).setCellValue(pro.getSkillCategory() == null ? ConstantUtils.EMPTY_STRING : pro.getSkillCategory());
            }
            if (colunm.getTypeOfRole()) {
                count++;
                row.createCell(count).setCellValue(pro.getTypeOfRole() == null ? ConstantUtils.EMPTY_STRING : pro.getTypeOfRole());
            }
            if (colunm.getSpecificSkills()) {
                count++;
                row.createCell(count).setCellValue(pro.getSpecificSkills() == null ? ConstantUtils.EMPTY_STRING : pro.getSpecificSkills());
            }
            if (colunm.getGeneralSkills()) {
                count++;
                row.createCell(count).setCellValue(pro.getGeneralSkills() == null ? ConstantUtils.EMPTY_STRING : pro.getGeneralSkills());
            }
            if (colunm.getClientDomain()) {
                count++;
                row.createCell(count).setCellValue(pro.getClientDomain().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getClientDomain().getName());
            }
            if (colunm.getMode()) {
                count++;
                row.createCell(count).setCellValue(pro.getMode().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getMode().getName());
            }
            if (colunm.getEmployer()) {
                count++;
                row.createCell(count).setCellValue(pro.getEmployer().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployer().getName());
            }
            if (colunm.getPrimeVendor()) {
                count++;
                row.createCell(count).setCellValue(pro.getPrimeVendor().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getPrimeVendor().getName());
            }
            if (colunm.getEndClient()) {
                count++;
                row.createCell(count).setCellValue(pro.getEndClient().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getEndClient().getName());
            }
            if (colunm.getCurrentProjectStartDate()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getCurrentProjectStartDate() == null ? ConstantUtils.EMPTY_STRING : pro.getCurrentProjectStartDate().toString());
            }
            if (colunm.getCurrentProjectEndDate()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getCurrentProjectEndDate() == null ? ConstantUtils.EMPTY_STRING : pro.getCurrentProjectEndDate().toString());
            }
            if (colunm.getEmail()) {
                count++;
                row.createCell(count)
                        .setCellValue(pro.getEmployee().getEmail() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getEmail());
            }
            if (colunm.getMobileNumber()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getEmployee().getMobileNumber() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getMobileNumber());
            }
            if (colunm.getHomePhone()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getEmployee().getHomePhone() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getHomePhone());
            }
            if (colunm.getWorkPhoneNumber()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getEmployee().getWorkPhoneNumber() == null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getWorkPhoneNumber());
            }
            if (colunm.getAdditionalNotifiers()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getAdditionalNotifiers() == null ? ConstantUtils.EMPTY_STRING : pro.getAdditionalNotifiers());
            }
            if (colunm.getBenchAge()) {
                count++;
                row.createCell(count).setCellValue(pro.getBenchAge() == null ? ConstantUtils.EMPTY_STRING : pro.getBenchAge());
            }
            if (colunm.getCity()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getCity() == null ? ConstantUtils.EMPTY_STRING : pro.getCity());
            }
            if (colunm.getDOB()) {
                count++;
                row.createCell(count).setCellValue(pro.getEmployee().getDOB() != null ? ConstantUtils.EMPTY_STRING : pro.getEmployee().getDOB());
            }
            if (colunm.getPayType()) {
                count++;
                row.createCell(count).setCellValue(pro.getPayType().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getPayType().getName());
            }
            if (colunm.getWorkExperience()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getWorkExperience() == null ? ConstantUtils.EMPTY_STRING : pro.getWorkExperience());
            }
            if (colunm.getWorkAuthorization()) {
                count++;
                row.createCell(count).setCellValue(pro.getWorkAuthorization().getName() == null ? ConstantUtils.EMPTY_STRING : pro.getWorkAuthorization().getName());
            }
            if (colunm.getTechnology()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getTechnology() == null ? ConstantUtils.EMPTY_STRING : pro.getTechnology());
            }
            if (colunm.getSellRate()) {
                count++;
                row.createCell(count).setCellValue(pro.getSellRate() == null ? ConstantUtils.EMPTY_STRING : pro.getSellRate());
            }
            if (colunm.getSource()) {
                count++;
                row.createCell(count).setCellValue(
                        pro.getSource() == null ? ConstantUtils.EMPTY_STRING : pro.getSource());
            }
            if (colunm.getAddedOn()) {
                count++;
                row.createCell(count).setCellValue(pro.getAddedOn() == null ? ConstantUtils.EMPTY_STRING : pro.getAddedOn().toString());
            }
            if (colunm.getRemarks()) {
                count++;
                row.createCell(count).setCellValue(pro.getRemarks() == null ? ConstantUtils.EMPTY_STRING : pro.getRemarks());
            }
            if (colunm.getLayerOne()) {
            	count++;
            	row.createCell(count).setCellValue(pro.getLayerOne() == null ? ConstantUtils.EMPTY_STRING : pro.getLayerOne());
            }
            if (colunm.getLayerTwo()) {
            	count++;
            	row.createCell(count).setCellValue(pro.getLayerTwo() == null ? ConstantUtils.EMPTY_STRING : pro.getLayerTwo());
            }
            if (colunm.getLayerThree()) {
            	count++;
            	row.createCell(count).setCellValue(pro.getLayerThree() == null ? ConstantUtils.EMPTY_STRING : pro.getLayerThree());
            }
            if (colunm.getLayerFour()) {
            	count++;
            	row.createCell(count).setCellValue(pro.getLayerFour() == null ? ConstantUtils.EMPTY_STRING : pro.getLayerFour());
            }
            if (colunm.getSrsJoiningDate()) {
            	count++;
            	row.createCell(count).setCellValue(
            		pro.getSrsJoiningDate() == null ? ConstantUtils.EMPTY_STRING : pro.getSrsJoiningDate().toString());
            }
            count = 0;
        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.debug("employee Excel generation Ended");
        return new ByteArrayInputStream(out.toByteArray());
    }

    /**
     * @param colunm
     * @return Array of Strings (Colunm)
     * method will create the array of Colunms selected by users
     */
    public String[] createColunm(Colunm colunm) {
        List<String> colList = new ArrayList<String>();

        // if(colunm.getId())
        colList.add(ConstantUtils.EMP_ID);
        if (colunm.getEmpType())
            colList.add(ConstantUtils.EMPLOYMENT_TYPE);
        if (colunm.getSrsEmpId())
            colList.add(ConstantUtils.SRS_EMP_ID);
        if (colunm.getFullName())
            colList.add(ConstantUtils.EMPLOYEE);
        if (colunm.getFirstName())
            colList.add(ConstantUtils.FIRST_NAME);
        if (colunm.getLastName())
            colList.add(ConstantUtils.LAST_NAME);
        if (colunm.getStatus())
            colList.add(ConstantUtils.ACTIVE_BENCH_EXIT);
        if (colunm.getLocation())
            colList.add(ConstantUtils.LOCATION);
        if (colunm.getTotalExperience())
            colList.add(ConstantUtils.TOTAL_EXPERIENCE);
        if (colunm.getEducation())
            colList.add(ConstantUtils.EDUCATION);
        if (colunm.getTitle())
            colList.add(ConstantUtils.TITLE);
        if (colunm.getCertification())
            colList.add(ConstantUtils.CERTIFICATION);
        if (colunm.getSkillCategory())
            colList.add(ConstantUtils.SKILL_CATEGORY);
        if (colunm.getTypeOfRole())
            colList.add(ConstantUtils.TYPE_ROLE);
        if (colunm.getSpecificSkills())
            colList.add(ConstantUtils.SPECIFIC_SKILLS);
        if (colunm.getGeneralSkills())
            colList.add(ConstantUtils.GENERAL_SKILLS);
        if (colunm.getClientDomain())
            colList.add(ConstantUtils.CLIENT_DOMAIN);
        if (colunm.getMode())
            colList.add(ConstantUtils.DIRECT_INDIRECT);
        if (colunm.getEmployer())
            colList.add(ConstantUtils.EMPLOYER);
        if (colunm.getPrimeVendor())
            colList.add(ConstantUtils.PRIME_VENDOR);
        if (colunm.getEndClient())
            colList.add(ConstantUtils.END_CLIENT);
        if (colunm.getCurrentProjectStartDate())
            colList.add(ConstantUtils.CURRENT_PROJECT_START_DATE);
        if (colunm.getCurrentProjectEndDate())
            colList.add(ConstantUtils.CURRENT_PROJECT_END_DATE);
        if (colunm.getEmail())
            colList.add(ConstantUtils.EMAIL);
        if (colunm.getMobileNumber())
            colList.add(ConstantUtils.MOBILE_NUMBER);
        if (colunm.getHomePhone())
            colList.add(ConstantUtils.HOME_NUMBER);
        if (colunm.getWorkPhoneNumber())
            colList.add(ConstantUtils.PHONE_NUMBER);
        if (colunm.getAdditionalNotifiers())
            colList.add(ConstantUtils.ADDITIONAL_NOTIFIERS);
        if (colunm.getBenchAge())
            colList.add(ConstantUtils.BENCH_AGE);
        if (colunm.getCity())
            colList.add(ConstantUtils.CITY);
        if (colunm.getDOB())
            colList.add(ConstantUtils.DATE_OF_BIRTH);
        if (colunm.getPayType())
            colList.add(ConstantUtils.PAY_TYPE);
        if (colunm.getWorkExperience())
            colList.add(ConstantUtils.WORK_EXPERIENCE);
        if (colunm.getWorkAuthorization())
            colList.add(ConstantUtils.WORK_AUTHORIZATION);
        if (colunm.getTechnology())
            colList.add(ConstantUtils.TECHNOLOGY);
        if (colunm.getSellRate())
            colList.add(ConstantUtils.SELL_RATE);
        if (colunm.getSource())
            colList.add(ConstantUtils.SOURCE);
        if (colunm.getAddedOn())
            colList.add(ConstantUtils.ADDED_ON);
        if (colunm.getRemarks())
            colList.add(ConstantUtils.REMARKS);
        if (colunm.getLayerOne())
            colList.add(ConstantUtils.LAYER_ONE);
        if (colunm.getLayerTwo())
            colList.add(ConstantUtils.LAYER_TWO);
        if (colunm.getLayerThree())
            colList.add(ConstantUtils.LAYER_THREE);
        if (colunm.getLayerFour())
            colList.add(ConstantUtils.LAYER_FOUR);
        if (colunm.getSrsJoiningDate())
            colList.add(ConstantUtils.SRS_JOINING_DATE);
        
        return colList.toArray(new String[colList.size()]);
    }

}