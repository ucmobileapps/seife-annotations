package com.weebmeister.seife.anno;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binding declaration, a binding defines a wiring between data in memory and an input field in a form.
 * The {@link #bindingOptions()} can also be defined globally for all form-fields bound to the input in {@link SeifeField#dataOptions()},
 * {@link #bindingOptions()} takes precedence.
 * For additional info see {@link SeifeForm}. 
 */
@Target({FIELD})
@Retention( value=RetentionPolicy.SOURCE )
public @interface SeifeBinding  {
	
	/** 
	 * Name of the data-element. If empty the name of the attribute field is used.
	 * @return defaults to empty string "". 
	 */
	String value() default "";

	/**
	 * Set to some value to assign an id to the component in the form, the default is to {@link #AUTO} for automatic assignment.
	 * An id is required if testing code should be created, use the empty string to explicitly prevent setting an id.
	 * @return defaults to {@link #AUTO}
	 */
	String id() default AUTO;
	
	/**
	 * Comment/description on the data
	 * @return defaults to empty string ""
	 */
	String description() default "";
	
	/**
	 * Optional specialization of the binding, e.g. {@link #TYPE_PASSWORD}.
	 * @return defaults to empty string ""
	 */
	String bindingOptions() default "";
	
	/**
	 * Template name that is used to determine the renderer
	 * @return defaults to empty string ""
	 */
	String renderTemplate() default "";
	
	/**
	 * Whether the generator should create an instance for you.
	 * @return default is true
	 */
	boolean instantiate() default true;
	
	/**
	 * Automatic assignment
	 */
	public static final String AUTO = "_automatic";

	/**
	 * Bind a password field
	 */
	public static final String TYPE_PASSWORD = "binding:password";
	
	/**
	 * Bind a localized field
	 */
	public static final String TYPE_LOCALIZED = "binding:localized";
}
