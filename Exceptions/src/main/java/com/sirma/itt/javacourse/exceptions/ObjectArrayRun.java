package com.sirma.itt.javacourse.exceptions;

/**
 * Run class, using the ObjectArray class's methods.
 * 
 * @author user
 */
public final class ObjectArrayRun {

	/**
	 * Private constructor so the class cannot be instantiated.
	 */
	private ObjectArrayRun() {

	}

	/**
	 * Static main method from which the program will start. Two exceptions will be thrown. The
	 * first one when we try to remove an element from the empty array. The second one when we try
	 * to add a sixth element, when the specified length is 5.
	 * 
	 * @param args
	 *            console-line arguments
	 */
	public static void main(String[] args) {
		ObjectArray objectArray = new ObjectArray(5);
		try {
			objectArray.remove();
		} catch (EmptyArrayException e) {
			System.out.println(e.getMessage());
		}
		try {
			objectArray.add(new Object());
			objectArray.add(new Object());
			objectArray.add(new Object());
			objectArray.add(new Object());
			objectArray.add(new Object());
			objectArray.add(new Object());
		} catch (FullArrayException e) {
			System.out.println(e.getMessage());
		}
	}

}
