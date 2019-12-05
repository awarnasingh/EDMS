package com.edms.core.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SearchHistory.class)
public abstract class SearchHistory_ {

	public static volatile SingularAttribute<SearchHistory, String> skills;
	public static volatile SingularAttribute<SearchHistory, String> employeeName;
	public static volatile SingularAttribute<SearchHistory, Double> fromExperience;
	public static volatile SingularAttribute<SearchHistory, String> empType;
	public static volatile SingularAttribute<SearchHistory, Double> toExperience;
	public static volatile SingularAttribute<SearchHistory, String> searchName;
	public static volatile SingularAttribute<SearchHistory, String> domain;
	public static volatile SingularAttribute<SearchHistory, String> location;
	public static volatile SingularAttribute<SearchHistory, Long> id;
	public static volatile SingularAttribute<SearchHistory, String> userID;
	public static volatile SingularAttribute<SearchHistory, String> endClient;
	public static volatile SingularAttribute<SearchHistory, String> status;

	public static final String SKILLS = "skills";
	public static final String EMPLOYEE_NAME = "employeeName";
	public static final String FROM_EXPERIENCE = "fromExperience";
	public static final String EMP_TYPE = "empType";
	public static final String TO_EXPERIENCE = "toExperience";
	public static final String SEARCH_NAME = "searchName";
	public static final String DOMAIN = "domain";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String USER_ID = "userID";
	public static final String END_CLIENT = "endClient";
	public static final String STATUS = "status";

}

