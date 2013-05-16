package com.sirma.itt.javacourse.inputoutput.task6;

import java.io.Serializable;

/**
 * A custom class which we will use for the purpose of testing our DataClass class.
 * 
 * @author user
 */
public class UserDefinedObject implements Serializable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 8645793604301419664L;
	private String name;

	/**
	 * Setting the name field of the class.
	 * 
	 * @param name
	 *            value to be set to the name field
	 */
	public UserDefinedObject(String name) {
		this.name = name;
	}

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
