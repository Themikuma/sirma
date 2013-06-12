package com.sirma.itt.javacourse.threads.task5;

/**
 * A simple test of the {@link ThreadSafeObjectArray}.
 * 
 * @author user
 */
public final class ObjectArrayTest {
	/**
	 * Disallowing the instantiation of this class with a private constructor.
	 */
	private ObjectArrayTest() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		ThreadSafeObjectArray demo = new ThreadSafeObjectArray(4);
		Thread firstThread = new Thread(demo.addElements(4));
		Thread secondThread = new Thread(demo.removeElements(5));
		firstThread.start();
		secondThread.start();

	}
}
