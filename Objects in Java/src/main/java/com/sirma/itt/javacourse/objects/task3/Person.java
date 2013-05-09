package com.sirma.itt.javacourse.objects.task3;

/**
 * Person class- every human being.
 * 
 * @author user
 */
public abstract class Person {
	private String name;

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
