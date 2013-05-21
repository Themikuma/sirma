package com.sirma.itt.javacourse.refanreg.task3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A class that uses the PrivateClass class and tries to call it's private methods and fields.
 * 
 * @author user
 */
public class ReflectionPrivateClass {
	private PrivateClass privateClass;
	private Method privateMethod;
	private Field privateField;

	/**
	 * A constructor, instantiating the privateClass class.
	 * 
	 * @param privateClass
	 *            the input class
	 */
	public ReflectionPrivateClass(PrivateClass privateClass) {
		this.privateClass = privateClass;
	}

	/**
	 * Switches between the two states of access of a given field.
	 */
	public void changeFieldAccess() {

		if (!privateField.isAccessible()) {
			privateField.setAccessible(true);
		} else
			privateField.setAccessible(false);

	}

	/**
	 * Switches between the two states of access of a given method.
	 */
	public void changeMethodAccess() {

		if (!privateMethod.isAccessible()) {
			privateMethod.setAccessible(true);
		} else
			privateMethod.setAccessible(false);

	}

	/**
	 * Tries to invoke a private method from a class by a given name.
	 * 
	 * @return the result from the invoked method
	 */
	public String invokePrivateClassMethod() {
		try {
			return (String) privateMethod.invoke(privateClass);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("You can't invoke private methods");
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong with the invoke");

		}

	}

	/**
	 * Tries to get the value of a private field.
	 * 
	 * @return the value of the private field
	 */
	public String getPrivateFieldValue() {

		try {
			return (String) privateField.get(privateClass);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("You can't get a value from a private field");
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong");
		}

	}

	/**
	 * Sets the privateMethod field from a given name.
	 * 
	 * @param name
	 *            the name of the method to be found in the {@link PrivateClass}
	 */
	public void setMethodFromName(String name) {
		try {
			privateMethod = privateClass.getClass().getDeclaredMethod(name);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("This method does not exist");
		} catch (SecurityException e) {
			throw new RuntimeException("You dont have access to that method");
		}
	}

	/**
	 * Sets the privateField field from a given name.
	 * 
	 * @param name
	 *            the name of the field to be found in the {@link PrivateClass}
	 */
	public void setFieldFromName(String name) {
		try {
			privateField = privateClass.getClass().getDeclaredField(name);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException("This field does not exist");
		} catch (SecurityException e) {
			throw new RuntimeException("You dont have access to that field");
		}
	}

	/**
	 * Getter method for privateClass.
	 * 
	 * @return the privateClass
	 */
	public PrivateClass getPrivateClass() {
		return privateClass;
	}

	/**
	 * Setter method for privateClass.
	 * 
	 * @param privateClass
	 *            the privateClass to set
	 */
	public void setPrivateClass(PrivateClass privateClass) {
		this.privateClass = privateClass;
	}

	/**
	 * Getter method for privateMethod.
	 * 
	 * @return the privateMethod
	 */
	public Method getPrivateMethod() {
		return privateMethod;
	}

	/**
	 * Setter method for privateMethod.
	 * 
	 * @param privateMethod
	 *            the privateMethod to set
	 */
	public void setPrivateMethod(Method privateMethod) {
		this.privateMethod = privateMethod;
	}

	/**
	 * Getter method for privateField.
	 * 
	 * @return the privateField
	 */
	public Field getPrivateField() {
		return privateField;
	}

	/**
	 * Setter method for privateField.
	 * 
	 * @param privateField
	 *            the privateField to set
	 */
	public void setPrivateField(Field privateField) {
		this.privateField = privateField;
	}

}
