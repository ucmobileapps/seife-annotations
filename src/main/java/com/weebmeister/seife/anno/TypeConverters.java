package com.weebmeister.seife.anno;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Scan any number of converter classes for a method 
 * with a matching signature. 
 * <ul><li>Will cause a compilation error if multiple converters are found</li>
 * <li>A field or method annotation precedes a class annotation</li></ul>
 * @author Klaus Sausen
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface TypeConverters {
	Class<?>[] value() default {};
}
