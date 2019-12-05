package com.edms.core.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Status.class)
public abstract class Status_ {

	public static volatile SingularAttribute<Status, String> name;
	public static volatile SingularAttribute<Status, Long> id;
	public static volatile SingularAttribute<Status, Boolean> status;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

