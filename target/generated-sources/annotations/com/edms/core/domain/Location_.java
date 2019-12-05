package com.edms.core.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Location.class)
public abstract class Location_ {

	public static volatile SingularAttribute<Location, String> name;
	public static volatile SingularAttribute<Location, Long> id;
	public static volatile SingularAttribute<Location, Boolean> status;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

