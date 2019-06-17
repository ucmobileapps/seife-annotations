package com.weebmeister.seife.anno;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Source-level annotation to preprocess form input. A {@link SeifeForm} annotated class will be processed to have 
 * form-field bindings attached to data fields.
 * @author Klaus Sausen
 */
@Target({TYPE})
@Retention( value=RetentionPolicy.SOURCE )
public @interface SeifeForm {

	/**
	 * The type containing the data fields that should be bound (annotated with {@link SeifeClass})
	 * @return mandatory class reference
	 */
	Class<?> forClass();
	
	/**
	 * Specify the generators and the particular options, see {@link GeneratorOption}
	 * @return array of strings, e.g. generatorOptions= { GeneratorOption.VAADIN_FORM, GeneratorOption.VAADIN_TESTING_GEB_MODULE }
	 */
	String[] generatorOptions() default {};
}
