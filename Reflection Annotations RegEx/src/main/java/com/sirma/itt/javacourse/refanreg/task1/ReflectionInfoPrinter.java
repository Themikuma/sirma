package com.sirma.itt.javacourse.refanreg.task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that uses the RandomClass class.
 * 
 * @author user
 */
public class ReflectionInfoPrinter {
	private RandomClass randomObject;

	/**
	 * A class constructor, initializing the RandomClass class.
	 * 
	 * @param randomObject
	 *            the class that is going to be manipulated by this class
	 */
	public ReflectionInfoPrinter(RandomClass randomObject) {
		this.randomObject = randomObject;
	}

	/**
	 * Using reflection to print out the methods of the RandomClass class.
	 * 
	 * @return List of methods from the class
	 */
	public List<String> printClassMethods() {
		Class<? extends RandomClass> randomObjectClass = getRandomObject().getClass();
		List<String> methods = new ArrayList<String>();
		for (Method method : randomObjectClass.getDeclaredMethods()) {
			methods.add(method.toString());
		}
		return methods;
	}

	/**
	 * Using reflection to print out the fields of the RandomClass class.
	 * 
	 * @return array of fields from the class
	 */
	public List<String> printClassFields() {
		Class<? extends RandomClass> randomObjectClass = getRandomObject().getClass();
		List<String> fields = new ArrayList<String>();
		for (Field field : randomObjectClass.getDeclaredFields()) {
			fields.add(field.toString());
		}
		return fields;
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
