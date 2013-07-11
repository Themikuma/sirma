package com.sirma.itt.javacourse.threads.task3;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A simple test of the {@link SleepingCounter}, since we can't write tests because we don't know
 * what the outcome will be .
 * 
 * @author user
 */
public final class SleepingCounterDemo {
	/**
	 * Disallowing the instantiation of this class with a private constructor.
	 */
	private SleepingCounterDemo() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		AtomicBoolean finished = new AtomicBoolean();
		SleepingCounter runnableThread = new SleepingCounter(1, 10000, finished);
		SleepingCounter runnableThreadTwo = new SleepingCounter(1, 3, finished);
		Thread thread = new Thread(runnableThread);
		Thread secondThread = new Thread(runnableThreadTwo);
		thread.start();
		secondThread.start();
	}

}
