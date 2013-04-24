package com.sirma.itt.javacourse.exceptions;

public class ObjectArrayRun {

	/**
	 * @param args
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
		} catch (FullArrayException e) {
			System.out.println(e.getMessage());
		}
	}

}
