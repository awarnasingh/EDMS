package com.edms.core.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PayType.class)
public abstract class PayType_ {

	public static volatile SingularAttribute<PayType, String> name;
	public static volatile SingularAttribute<PayType, Long> id;
	public static volatile SingularAttribute<PayType, Boolean> status;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

