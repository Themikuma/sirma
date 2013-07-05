package com.sirma.itt.javacourse.threads.task2;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The runnable object which counts to a given number or until one of the threads has finished
 * counting. We are using an {@link AtomicBoolean} because you should never synchronize on a normal
 * one.
 * 
 * @author user
 */
public class Counter implements Runnable {
	private final int min;
	private final int max;
	private AtomicBoolean finished;

	/**
	 * Setting up the min and max values.
	 * 
	 * @param min
	 *            the number from which the object is going to count up
	 * @param max
	 *            the number to which the object is going to count
	 * @param finished
	 *            indicates when one of the threads has finished counting
	 */
	public Counter(int min, int max, AtomicBoolean finished) {
		this.min = min;
		this.max = max;
		this.finished = finished;
	}

	@Override
	public void run() {
		int iterator = min;
		while (!finished.get() && iterator < max) {
			iterator++;
			System.out.println(Thread.currentThread().getName() + " " + iterator);

		}
		synchronized (this) {
			finished.set(true);
		}

	}
}
