package com.sirma.itt.javacourse.threads.task3;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The runnable object which counts to a given number with a delay or until one of the threads has
 * finished counting.
 * 
 * @author user
 */
public class WaitingCounter implements Runnable {
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
	 *            indicates if one of the threads has stopped counting
	 */
	public WaitingCounter(int min, int max, AtomicBoolean finished) {
		this.min = min;
		this.max = max;
		this.finished = finished;
	}

	@Override
	public void run() {
		int iterator = min;
		while (!finished.get() && iterator <= max) {
			System.out.println(Thread.currentThread().getName() + " " + iterator);
			try {
				Thread.sleep(100 + (int) (Math.random() * 900 + 1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iterator++;
		}

		finished.set(true);

	}
}
