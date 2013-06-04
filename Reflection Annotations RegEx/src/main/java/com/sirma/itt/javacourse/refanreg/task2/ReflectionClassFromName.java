package com.sirma.itt.javacourse.refanreg.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * A class, instantiating the Random class by its name.
 * 
 * @author user
 */
public class ReflectionClassFromName {

	/**
	 * Printing out all the interfaces of a given class.
	 * 
	 * @param className
	 *            the name of the class to be opened
	 * @return a list with the class's interfaces
	 * @throws ClassNotFoundException
	 *             if the class is not found
	 */

	public List<String> printClassInterfaces(String className) throws ClassNotFoundException {
		List<String> interfaces = new ArrayList<String>();
		for (Class<?> randomObjectInterface : Class.forName(className).getInterfaces()) {
			interfaces.add(randomObjectInterface.toString());
		}
		return interfaces;
	}

	/**
	 * Printing out the superclass of a given class.
	 * 
	 * @param className
	 *            the name of the class to be opened
	 * @return the superclass converted to string
	 * @throws ClassNotFoundException
	 *             if the class is not found
	 */

	public String printClassParrent(String className) throws ClassNotFoundException {
		return Class.forName(className).getSuperclass().toString();
	}

}
