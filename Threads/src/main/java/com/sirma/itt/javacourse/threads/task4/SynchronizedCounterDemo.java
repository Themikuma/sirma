package com.sirma.itt.javacourse.threads.task4;

/**
 * A simple test of the {@link SynchronizedCounter}, since we can't write tests because we don't
 * know what the outcome will be .
 * 
 * @author user
 */
public final class SynchronizedCounterDemo {
	/**
	 * Disallowing the instantiation of this class with a private constructor.
	 */
	private SynchronizedCounterDemo() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		SynchronizedCounter runnableThread = new SynchronizedCounter(5, 10);
		SynchronizedCounter runnableThreadTwo = new SynchronizedCounter(1, 50);
		Thread thread = new Thread(runnableThread);
		Thread secondThread = new Thread(runnableThreadTwo);
		thread.start();
		secondThread.start();

	}
}
