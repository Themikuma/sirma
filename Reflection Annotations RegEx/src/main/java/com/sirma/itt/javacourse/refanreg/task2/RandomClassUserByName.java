package com.sirma.itt.javacourse.refanreg.task2;

/**
 * A class, instantiating the Random class by its name.
 * 
 * @author user
 */
public class RandomClassUserByName {

	/**
	 * Trying to instantiate a class by its name and print the interfaces it implements and its
	 * parent.
	 * 
	 * @param name
	 *            The name of the class we are trying to instantiate
	 */
	public void printClassInfo(String name) {
		Class<?> randomClass = null;
		try {
			randomClass = Class.forName(name);
			randomClass.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Printing implemented interfaces");
		for (Class<?> randomObjectInterface : randomClass.getInterfaces()) {
			System.out.println(randomObjectInterface);
		}
		System.out.println("Printing parent");
		System.out.println(randomClass.getSuperclass());
	}
}
