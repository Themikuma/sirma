package com.sirma.itt.javacourse.refanreg.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * A class, instantiating the Random class by its name.
 * 
 * @author user
 */
public class ReflectionClassFromName {
	private Class<?> randomClass;

	/**
	 * Printing out all the interfaces of a given class.
	 * 
	 * @return a list with the class's interfaces
	 */
	public List<String> printClassInterfaces() {
		List<String> interfaces = new ArrayList<String>();
		for (Class<?> randomObjectInterface : randomClass.getInterfaces()) {
			interfaces.add(randomObjectInterface.toString());
		}
		return interfaces;
	}

	/**
	 * Printing out the superclass of a given class.
	 * 
	 * @return the superclass converted to string
	 */
	public String printClassParrent() {
		return randomClass.getSuperclass().toString();
	}

	/**
	 * Instantiating a class by its name.
	 * 
	 * @param name
	 *            the name of the class
	 * @throws ClassNotFoundException
	 *             when the class we are trying to instantiate by name does not exist
	 * @throws IllegalAccessException
	 *             when we don't have access to the class
	 * @throws InstantiationException
	 *             when the class has no means of instantiation
	 */
	public void setClass(String name) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		randomClass = Class.forName(name);
		randomClass.newInstance();

	}

	/**
	 * Getter method for randomClass.
	 * 
	 * @return the randomClass
	 */
	public Class<?> getRandomClass() {
		return randomClass;
	}

	/**
	 * Setter method for randomClass.
	 * 
	 * @param randomClass
	 *            the randomClass to set
	 */
	public void setRandomClass(Class<?> randomClass) {
		this.randomClass = randomClass;
	}
}
