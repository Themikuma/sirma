package com.sirma.itt.javacourse.threads.task2;

/**
 * A simple test of the {@link Counter}, since we can't write tests because we don't know what the
 * outcome will be .
 * 
 * @author user
 */
public final class CounterDemo {
	/**
	 * Disallowing the instantiation of this class with a private constructor.
	 */
	private CounterDemo() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		Counter runnableThread = new Counter(1, 10000);
		Counter runnableThreadTwo = new Counter(1, 3);
		Thread thread = new Thread(runnableThread);
		Thread secondThread = new Thread(runnableThreadTwo);
		thread.start();
		secondThread.start();

	}
}
