package com.sirma.itt.javacourse.designpatterns.task3;

/**
 * A class implementing the singleton design pattern.
 * 
 * @author user
 */
// TODO fix singleton for threads
public final class Singleton {
	private static Singleton instance;

	/**
	 * A constructor that can be called only from inside this class to prevent instantiation.
	 */
	private Singleton() {
		System.out.println("Singleton created");
	}

	/**
	 * Getter method for instance. Using lazy initialization to delay the creation of the singleton
	 * until it's needed.
	 * 
	 * @return the instance
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
