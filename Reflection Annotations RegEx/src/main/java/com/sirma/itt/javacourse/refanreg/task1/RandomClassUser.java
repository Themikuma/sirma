package com.sirma.itt.javacourse.refanreg.task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A class that uses the RandomClass class.
 * 
 * @author user
 */
public class RandomClassUser {
	private RandomClass randomObject;

	/**
	 * A class constructor, initializing the RandomClass class.
	 */
	public RandomClassUser() {
		setRandomObject(new RandomClass());
	}

	/**
	 * Using reflection to print out the methods and variables of the RandomClass class.
	 */
	public void printInfo() {
		Class<? extends RandomClass> randomObjectClass = getRandomObject().getClass();
		System.out.println("Printing class methods");
		for (Method randomObjectMethod : randomObjectClass.getDeclaredMethods()) {
			System.out.println(randomObjectMethod);
		}
		System.out.println("Printing class fields");
		for (Field randomObjectField : randomObjectClass.getDeclaredFields()) {
			System.out.println(randomObjectField);
		}
	}

	/**
	 * Getter method for randomObject.
	 * 
	 * @return the randomObject
	 */
	public RandomClass getRandomObject() {
		return randomObject;
	}

	/**
	 * Setter method for randomObject.
	 * 
	 * @param randomObject
	 *            the randomObject to set
	 */
	public void setRandomObject(RandomClass randomObject) {
		this.randomObject = randomObject;
	}
}
