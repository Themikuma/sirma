package com.sirma.itt.javacourse.threads.task2;

import java.util.concurrent.atomic.AtomicBoolean;

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
		AtomicBoolean finished = new AtomicBoolean();

		Thread thread = new Thread(new Counter(1, 4000, finished));
		Thread secondThread = new Thread(new Counter(1, 3, finished));
		thread.start();
		secondThread.start();

	}
}
