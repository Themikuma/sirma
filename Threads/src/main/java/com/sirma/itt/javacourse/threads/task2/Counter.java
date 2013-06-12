package com.sirma.itt.javacourse.threads.task2;

/**
 * The runnable object which counts to a given number or until one of the threads has finished
 * counting.
 * 
 * @author user
 */
public class Counter implements Runnable {
	private final int min;
	private final int max;
	private static boolean finished;

	/**
	 * Setting up the min and max values.
	 * 
	 * @param min
	 *            the number from which the object is going to count up
	 * @param max
	 *            the number to which the object is going to count
	 */
	public Counter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		int iterator = min;
		while (!finished && iterator <= max) {
			iterator++;
			System.out.println(Thread.currentThread().getName() + " " + iterator);

		}
		finished = true;

	}
}
