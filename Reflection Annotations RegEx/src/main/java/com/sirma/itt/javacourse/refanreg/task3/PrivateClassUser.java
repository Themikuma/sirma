package com.sirma.itt.javacourse.refanreg.task3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
	 */
	public PrivateClassUser() {
		this.privateClass = new PrivateClass();
	}

	/**
	 * Instantiating the PrivateClass class, accessing its private methods and fields and displaying
	 * their values.
	 */
	public void printPrivateInfo() {
		Class<? extends PrivateClass> privateInfo = privateClass.getClass();
		Method privateClassMethod;
		Field privateClassField;
		try {
			privateClassMethod = privateInfo.getDeclaredMethod("callMe");
			privateClassField = privateInfo.getDeclaredField("changeMe");
			privateClassField.setAccessible(true);
			System.out.println(privateClassField.get(privateClass));
			privateClassMethod.setAccessible(true);
			privateClassMethod.invoke(privateClass);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
