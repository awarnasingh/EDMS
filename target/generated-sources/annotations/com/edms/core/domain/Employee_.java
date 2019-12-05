package com.edms.core.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> lastName;
	public static volatile SingularAttribute<Employee, String> education;
	public static volatile SingularAttribute<Employee, String> updatedBy;
	public static volatile SingularAttribute<Employee, EmpType> empType;
	public static volatile SingularAttribute<Employee, String> srsEmpId;
	public static volatile SingularAttribute<Employee, String> mobileNumber;
	public static volatile SingularAttribute<Employee, String> homePhone;
	public static volatile SingularAttribute<Employee, String> fullName;
	public static volatile SingularAttribute<Employee, LocalDate> updatedDate;
	public static volatile SingularAttribute<Employee, String> certification;
	public static volatile SingularAttribute<Employee, String> firstName;
	public static volatile SingularAttribute<Employee, LocalDate> createdDate;
	public static volatile SingularAttribute<Employee, String> createdBy;
	public static volatile SingularAttribute<Employee, String> workPhoneNumber;
	public static volatile SingularAttribute<Employee, String> DOB;
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, Status> status;

	public static final String LAST_NAME = "lastName";
	public static final String EDUCATION = "education";
	public static final String UPDATED_BY = "updatedBy";
	public static final String EMP_TYPE = "empType";
	public static final String SRS_EMP_ID = "srsEmpId";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String HOME_PHONE = "homePhone";
	public static final String FULL_NAME = "fullName";
	public static final String UPDATED_DATE = "updatedDate";
	public static final String CERTIFICATION = "certification";
	public static final String FIRST_NAME = "firstName";
	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String WORK_PHONE_NUMBER = "workPhoneNumber";
	public static final String D_OB = "DOB";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";

}

