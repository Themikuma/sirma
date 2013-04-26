package com.sirma.itt.javacourse.refanreg;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateClassUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrivateClass privateClass = new PrivateClass();
		Class privateInfo = privateClass.getClass();
		Method privateClassMethod;
		Field privateClassField;
		try {
			privateClassMethod = privateInfo.getDeclaredMethod("callMe", null);
			privateClassField = privateInfo.getDeclaredField("changeMe");
			privateClassField.setAccessible(true);
			System.out.println(privateClassField.get(privateClass));
			privateClassMethod.setAccessible(true);
			privateClassMethod.invoke(privateClass, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
