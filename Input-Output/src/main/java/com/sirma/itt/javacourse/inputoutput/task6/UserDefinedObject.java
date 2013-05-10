package com.sirma.itt.javacourse.inputoutput.task6;

import java.io.Serializable;

public class UserDefinedObject implements Serializable {

	private String name;

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
