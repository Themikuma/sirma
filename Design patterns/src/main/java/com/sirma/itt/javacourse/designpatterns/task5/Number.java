package com.sirma.itt.javacourse.designpatterns.task5;

/**
 * The common interface of the real object and the proxy so the proxy can be used anywhere where the
 * real object is expected.
 * 
 * @author user
 */
public interface Number {
	/**
	 * An example method for getting the real number.
	 * 
	 * @return some data from the {@link Integer} class
	 */
	int getRealNumber();
}
