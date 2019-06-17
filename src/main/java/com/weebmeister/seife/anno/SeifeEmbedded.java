package com.weebmeister.seife.anno;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field of an 1..1 complex type to be embedded in the parent object 
 * The type of the field needs the {@link SeifeField} annotation. 
 * @author Klaus Sausen
 */
@Target({FIELD, METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface SeifeEmbedded {
	
	/**
	 * The prefix to prepend to each field of the embedded class e.g. 
	 * <pre>adr_</pre>
	 * @return default value is the empty String ""
	 */
	String prefix() default "";
}
