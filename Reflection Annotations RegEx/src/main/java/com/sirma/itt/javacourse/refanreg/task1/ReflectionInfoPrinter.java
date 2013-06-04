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

	/**
	 * Using reflection to print out the methods of the RandomClass class.
	 * 
	 * @param randomObject
	 *            The random object which methods we are going to get
	 * @return List of methods from the class
	 */
	public List<String> printClassMethods(RandomClass randomObject) {
		List<String> methods = new ArrayList<String>();
		for (Method method : randomObject.getClass().getDeclaredMethods()) {
			methods.add(method.toString());
		}
		return methods;
	}

	/**
	 * Using reflection to print out the fields of the RandomClass class.
	 * 
	 * @param randomObject
	 *            The random object which methods we are going to get
	 * @return array of fields from the class
	 */
	public List<String> printClassFields(RandomClass randomObject) {
		List<String> fields = new ArrayList<String>();
		for (Field field : randomObject.getClass().getDeclaredFields()) {
			fields.add(field.toString());
		}
		return fields;
	}

}
