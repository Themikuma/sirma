package com.sirma.itt.javacourse.threads.task4;

/**
 * A simple test of the {@link SynchronizedCounterObject}, since we can't write tests because we
 * don't know what the outcome will be .
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
		SynchronizedCounterObject object = new SynchronizedCounterObject();
		SynchronizedCounterThread runnableThread = new SynchronizedCounterThread(5, 10, object);
		SynchronizedCounterThread runnableThreadTwo = new SynchronizedCounterThread(1, 50, object);
		Thread thread = new Thread(runnableThread);
		Thread secondThread = new Thread(runnableThreadTwo);
		thread.start();
		secondThread.start();

	}
}
