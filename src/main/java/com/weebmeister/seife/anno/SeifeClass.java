/**
 * 
 */
package com.weebmeister.seife.anno;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Source level annotation to enhance Java business object by additional 
 * meta-information for the Seife advanced code generator. 
 * @author Klaus Sausen
 */
@Target({TYPE})
@Retention( value=RetentionPolicy.SOURCE )
public @interface SeifeClass {
	/**
	 * A code generator specific description, currently unused
	 * @return defaults to empty string
	 */
	String description() default "";

	/**
	 * Specify the generators and the particular options, see {@link GeneratorOption}.
	 * @return array of strings, e.g. generatorOptions = { GeneratorOption.VAADIN_GRID }
	 */
	String[] generatorOptions() default {};

	/**
	 * Specify the name of the SQL table if it should not be named after the as the Java object
	 * @return defaults to empty string
	 */
	String sqlTablename() default "";

	/**
	 * This is used for the database creation
	 * @return API version of the class, default 0
	 */
	int version() default 0;

	/** 
	 * Advanced class specific options, this used by plugins that are usually not enabled,
	 * see the plugin documentation.
	 * @return array of strings
	 */
	String[] classOptions() default {};

}
