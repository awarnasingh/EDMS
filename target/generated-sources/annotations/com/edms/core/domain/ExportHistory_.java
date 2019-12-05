package com.edms.core.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExportHistory.class)
public abstract class ExportHistory_ {

	public static volatile SingularAttribute<ExportHistory, String> employeeName;
	public static volatile SingularAttribute<ExportHistory, Double> fromExperience;
	public static volatile SingularAttribute<ExportHistory, Boolean> exportDownload;
	public static volatile SingularAttribute<ExportHistory, EmpType> empType;
	public static volatile SingularAttribute<ExportHistory, Double> toExperience;
	public static volatile SingularAttribute<ExportHistory, String> userID;
	public static volatile SingularAttribute<ExportHistory, EndClient> endClient;
	public static volatile SingularAttribute<ExportHistory, String> skills;
	public static volatile SingularAttribute<ExportHistory, LocalDateTime> exportDate;
	public static volatile SingularAttribute<ExportHistory, ClientDomain> domain;
	public static volatile SingularAttribute<ExportHistory, Location> location;
	public static volatile SingularAttribute<ExportHistory, Long> id;
	public static volatile SingularAttribute<ExportHistory, Integer> rowCount;
	public static volatile SingularAttribute<ExportHistory, Boolean> exportMail;
	public static volatile SingularAttribute<ExportHistory, Status> status;

	public static final String EMPLOYEE_NAME = "employeeName";
	public static final String FROM_EXPERIENCE = "fromExperience";
	public static final String EXPORT_DOWNLOAD = "exportDownload";
	public static final String EMP_TYPE = "empType";
	public static final String TO_EXPERIENCE = "toExperience";
	public static final String USER_ID = "userID";
	public static final String END_CLIENT = "endClient";
	public static final String SKILLS = "skills";
	public static final String EXPORT_DATE = "exportDate";
	public static final String DOMAIN = "domain";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String ROW_COUNT = "rowCount";
	public static final String EXPORT_MAIL = "exportMail";
	public static final String STATUS = "status";

}

