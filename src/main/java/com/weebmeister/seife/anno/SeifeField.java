package com.weebmeister.seife.anno;
/**
 * 
 */

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks an attribute for processing in the context of the {@link SeifeClass}.
 * 
 * @author Klaus Sausen
 */
@Target({ FIELD, METHOD })
@Retention(value = RetentionPolicy.SOURCE)
public @interface SeifeField {
	/**
	 * Name of the data-element
	 * 
	 * @return defaults to the empty string
	 */
	String dataName() default "";

	/**
	 * Additional options for the database layer
	 * 
	 * @return {@link SqlFieldOptions}
	 */
	SqlFieldOptions sqlOptions() default @SqlFieldOptions;

	/**
	 * Special options are encoded as Strings in this array, e.g. for extensions see
	 * SeifeExtension. This can also contain definitions as
	 * {@link SeifeBinding#TYPE_PASSWORD} to globally define the field as having
	 * non-visible character input, there can only be one binding type per field.
	 * See also {@link SeifeBinding}.
	 * 
	 * @return array of strings
	 */
	String[] dataOptions() default {};

	/**
	 * DB: specify whether the field may be null
	 * 
	 * @return default is false
	 */
	boolean mandatory() default false;

	/**
	 * DB: specify whether the field is a primary key
	 * 
	 * @return default is false
	 */
	boolean isPrimaryKey() default false;

	/**
	 * Define a foreign key on both, country and language fields e.g.
	 * 
	 * <pre>
	 * foreignKey = @ForeignkeyDef(keyField="locale", keyClass=Language.class),
	 * </pre>
	 * 
	 * @return default to an empty {@link ForeignkeyDef}
	 */
	ForeignkeyDef foreignKey() default @ForeignkeyDef(refClass = Object.class, refKeyField = "", fkField = "");

	/**
	 * Api version of the field, can be used e.g. for db-upgrades
	 * 
	 * @return default is 0
	 */
	int version() default 0;

	/**
	 * Comment/description on the data
	 * 
	 * @return defaults to empty string ""
	 */
	String description() default "";
}
