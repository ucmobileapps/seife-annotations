package com.weebmeister.seife.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a class to be embeddable via a field as an 1 to 0..1 relation. 
 * Fields using a {@link SeifeEmbeddable} class refer to it via the {@link SeifeEmbedded} annotation
 * @author Klaus Sausen
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface SeifeEmbeddable {
}
