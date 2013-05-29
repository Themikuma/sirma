package com.sirma.itt.javacourse.designpatterns.task5;

/**
 * A factory that creates instances of the {@link IntegerProxy}.
 * 
 * @author user
 */
public final class IntegerFactory {

	/**
	 * Preventing the instantiation of the factory.
	 */
	private IntegerFactory() {

	}

	/**
	 * Creates an instance of the {@link IntegerProxy}.
	 * 
	 * @return an {@link IntegerProxy}
	 */
	public static IntegerProxy createInstance() {
		return new IntegerProxy();
	}
}
