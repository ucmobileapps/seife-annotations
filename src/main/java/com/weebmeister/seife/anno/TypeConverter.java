package com.weebmeister.seife.anno;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Will perform special handling on the static methods of the class with one
 * parameter and a non-void result.
 * 
 * @author Klaus Sausen
 */
@Documented
@Target(METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface TypeConverter {
	// will perform special handling on the static methods of the class with one
	// parameter and non-void result
}
