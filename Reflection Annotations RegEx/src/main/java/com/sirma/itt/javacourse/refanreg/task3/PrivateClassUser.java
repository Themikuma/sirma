package com.sirma.itt.javacourse.refanreg.task3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A class that uses the PrivateClass class and tries to call it's private methods and fields.
 * 
 * @author user
 */
public class PrivateClassUser {
	private PrivateClass privateClass;

	/**
	 * A constructor, instantiating the privateClass class.
	 * 
	 * @param privateClass
	 *            the input class
	 */
	public PrivateClassUser(PrivateClass privateClass) {
		this.privateClass = privateClass;
	}

	// TODO add tests
	// TODO change names !

	/**
	 * Switches between the two states of access of a given field.
	 * 
	 * @param name
	 *            the name of the field
	 */
	public void changeFieldAccess(String name) {
		try {
			Field privateClassField = privateClass.getClass().getDeclaredField(name);
			if (!privateClassField.isAccessible()) {
				privateClassField.setAccessible(true);

			} else
				privateClassField.setAccessible(false);
		} catch (Exception e) {
			throw new RuntimeException(
					"An exception occured while trying to switch the field's access", e);
		}
	}

	/**
	 * Switches between the two states of access of a given method.
	 * 
	 * @param name
	 *            the name of the method
	 */
	public void changeMethodAccess(String name) {
		try {
			Method privateClassMethod = privateClass.getClass().getDeclaredMethod(name);
			if (!privateClassMethod.isAccessible()) {
				privateClassMethod.setAccessible(true);
			} else
				privateClassMethod.setAccessible(false);
		} catch (Exception e) {
			System.out.println("An exception occured while trying to switch the method's access");
		}
	}

	/**
	 * Tries to invoke a private method from a class by a given name.
	 * 
	 * @param name
	 * @return
	 */
	public String invokePrivateClassMethod(String name) {
		try {
			return (String) privateClass.getClass().getDeclaredMethod(name).invoke(privateClass);
		} catch (Exception e) {
			System.out.println("An exception occured while trying to invoke the method");
		}
		return null;

	}

	public String getPrivateFieldValue(String name) {

		try {
			return (String) privateClass.getClass().getDeclaredField(name).get(privateClass);
		} catch (Exception e) {
			System.out.println("An exception occured while trying to switch the field's access");
		}
		return null;

	}

}
