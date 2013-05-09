package com.sirma.itt.javacourse.refanreg.task4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Creating a custom annotation with some kind of numbering.
 * 
 * @author user
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Numbered {
	/**
	 * Id of the class that is annotated.
	 */
	int id();
}
