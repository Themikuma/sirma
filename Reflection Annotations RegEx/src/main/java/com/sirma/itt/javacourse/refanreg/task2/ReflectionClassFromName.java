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
	 * Setting up the randomClass.
	 * 
	 * @param className
	 *            the name of the class to be instantiated
	 */
	public ReflectionClassFromName(String className) {
		this.randomClass = initClass(className);
	}

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
	 * @return the instantiated class itself
	 */
	private Class<?> initClass(String name) {
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
		return randomClass;
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
