package com.weebmeister.seife.anno;

/**
 * Annotation to define foreign key relations
 * @author Klaus Sausen
 */
public @interface ForeignkeyDef {
	
	/**
	 * Set the name of the foreign key field in this BO that holds the reference to the java instance (mandatory)
	 * @return field is mandatory
	 */
	String fkField();
	
	/**
	 * Set this to the name of the primary key part of the referenced class. For <i>combined</i> keys,
	 * if {@link #fkField()} is pointing to a BO that has a combined primary key
	 * all fields need to be declared in separate instance attributes to create the sql-references constraints accordingly (see the examples)
	 * @return field is mandatory
	 */
	String refKeyField();

	/**
	 * The bo-class the field is referencing
	 * @return defaults to {@link Object}
	 */
	Class<?> refClass() default Object.class;
}
