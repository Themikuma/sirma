package com.sirma.itt.javacourse.refanreg;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author user
 */
public class RandomClassUser {
	private RandomClass randomObject;

	public RandomClassUser() {
		randomObject = new RandomClass();
	}

	public void printInfo() {
		Class randomObjectClass = randomObject.getClass();
		System.out.println("Printing class methods");
		for (Method randomObjectMethod : randomObjectClass.getDeclaredMethods()) {
			System.out.println(randomObjectMethod);
		}
		System.out.println("Printing class fields");
		for (Field randomObjectField : randomObjectClass.getDeclaredFields()) {
			System.out.println(randomObjectField);
		}
	}
}
