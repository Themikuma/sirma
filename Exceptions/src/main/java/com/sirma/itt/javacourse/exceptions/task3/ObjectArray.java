package com.sirma.itt.javacourse.exceptions.task3;

/**
 * A Class containing an array of objects and some common array functionality.
 * 
 * @author user
 */
public class ObjectArray {
	private Object[] objectArray;
	private int iterator = 0;

	/**
	 * Constructor of the class, specifying the length of the array of objects.
	 * 
	 * @param length
	 *            the length of the array
	 */
	public ObjectArray(int length) {
		objectArray = new Object[length];
	}

	/**
	 * Adding an object to the array. If the array's length exceeds the specified length, a
	 * FullArrayException is thrown.
	 * 
	 * @param object
	 *            the object to be added to the array.
	 */
	public void add(Object object) {
		if (iterator == objectArray.length) {
			throw new FullArrayException("The array is full");
		}
		objectArray[iterator] = object;
		iterator++;
	}

	/**
	 * Removing an object from the array. If the iterator has already reached 0, there is nothing to
	 * remove and an exception is thrown.
	 */
	public void remove() {
		iterator--;
		if (iterator == -1) {
			iterator = 0;
			throw new EmptyArrayException("The array is empty");
		}
		objectArray[iterator] = null;

	}

	/**
	 * A Method, printing out all elements of the array in the console.
	 */
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
