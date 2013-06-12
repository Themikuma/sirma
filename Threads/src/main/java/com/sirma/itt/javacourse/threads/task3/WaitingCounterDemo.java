package com.sirma.itt.javacourse.threads.task3;

/**
 * A simple test of the {@link WaitingCounter}, since we can't write tests because we don't know
 * what the outcome will be .
 * 
 * @author user
 */
public final class WaitingCounterDemo {
	/**
	 * Disallowing the instantiation of this class with a private constructor.
	 */
	private WaitingCounterDemo() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		WaitingCounter runnableThread = new WaitingCounter(1, 10000);
		WaitingCounter runnableThreadTwo = new WaitingCounter(1, 3);
		Thread thread = new Thread(runnableThread);
		Thread secondThread = new Thread(runnableThreadTwo);
		thread.start();
		secondThread.start();
	}

}
