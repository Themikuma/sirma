package com.sirma.itt.javacourse.designpatterns.task5;

/**
 * The proxy of the real object, containing a reference to the real object for access.
 * 
 * @author user
 */
public class IntegerProxy implements Number {
	private Integer integerObject = new Integer();

	@Override
	public int getRealNumber() {
		return integerObject.getRealNumber();
	}

	/**
	 * Getter method for integerObject.
	 * 
	 * @return the integerObject
	 */
	public Integer getIntegerObject() {
		return integerObject;
	}

	/**
	 * Setter method for integerObject.
	 * 
	 * @param integerObject
	 *            the integerObject to set
	 */
	public void setIntegerObject(Integer integerObject) {
		this.integerObject = integerObject;
	}

}
