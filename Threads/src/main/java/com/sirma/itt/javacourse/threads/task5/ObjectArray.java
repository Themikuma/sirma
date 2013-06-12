package com.sirma.itt.javacourse.threads.task5;

/**
 * A Class containing an array of objects and some common array functionality.
 * 
 * @author user
 */
public class ObjectArray {
	private Object[] objectArray;
	private int iterator = 0;
	private boolean continueExecution;

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
	public synchronized void add(Object object) {

		if (iterator == objectArray.length) {

			System.out.println(Thread.currentThread().getName()
					+ " is waiting for an object to be removed ");
			continueExecution = false;
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!continueExecution)
				return;
		}
		objectArray[iterator] = object;
		iterator++;

		continueExecution = true;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " object added");
	}

	/**
	 * Removing an object from the array. If the iterator has already reached 0, there is nothing to
	 * remove and an exception is thrown.
	 */
	public synchronized void remove() {

		if (iterator == 0) {

			System.out.println(Thread.currentThread().getName()
					+ " is waiting for an object in the array");
			continueExecution = false;
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!continueExecution)
				return;
		}
		objectArray[iterator - 1] = null;
		iterator--;
		continueExecution = true;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " object removed");

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
