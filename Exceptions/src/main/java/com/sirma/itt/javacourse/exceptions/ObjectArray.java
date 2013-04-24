package com.sirma.itt.javacourse.exceptions;

public class ObjectArray {
	private Object[] objectArray;
	private int iterator = 0;

	public ObjectArray(int length) {
		objectArray = new Object[length];
	}

	public void add(Object object) throws FullArrayException {
		if (iterator == objectArray.length - 1) {
			throw new FullArrayException("The array is full");
		}
		objectArray[iterator] = object;
		iterator++;
	}

	public void remove() throws EmptyArrayException {
		if (iterator == 0) {
			throw new EmptyArrayException("The array is empty");
		}
		objectArray[iterator] = null;
		iterator--;

	}

	public void printAllElements() {
		for (Object obj : objectArray) {
			System.out.print(obj + " ");
		}
	}

	/**
	 * Getter method for objectArray.
	 * 
	 * @return the objectArray
	 */
	public Object[] getObjectArray() {
		return objectArray;
	}

	/**
	 * Setter method for objectArray.
	 * 
	 * @param objectArray
	 *            the objectArray to set
	 */
	public void setObjectArray(Object[] objectArray) {
		this.objectArray = objectArray;
	}

}
