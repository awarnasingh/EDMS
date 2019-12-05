package com.edms.core.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmpType.class)
public abstract class EmpType_ {

	public static volatile SingularAttribute<EmpType, String> name;
	public static volatile SingularAttribute<EmpType, Long> id;
	public static volatile SingularAttribute<EmpType, Boolean> status;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

