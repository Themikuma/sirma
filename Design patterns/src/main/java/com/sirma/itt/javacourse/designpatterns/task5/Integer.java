package com.sirma.itt.javacourse.designpatterns.task5;

/**
 * The real subject of the proxy pattern.
 * 
 * @author user
 */
public class Integer implements Number {

	private int someData = 5;

	@Override
	public int getRealNumber() {
		return getSomeData();

	}

	/**
	 * Getter method for someData.
	 * 
	 * @return the someData
	 */
	public int getSomeData() {
		return someData;
	}

	/**
	 * Setter method for someData.
	 * 
	 * @param someData
	 *            the someData to set
	 */
	public void setSomeData(int someData) {
		this.someData = someData;
	}

}
