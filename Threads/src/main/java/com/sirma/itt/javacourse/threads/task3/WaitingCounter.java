package com.sirma.itt.javacourse.threads.task3;

/**
 * The runnable object which counts to a given number with a delay or until one of the threads has
 * finished counting.
 * 
 * @author user
 */
public class WaitingCounter implements Runnable {
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
	public WaitingCounter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		int iterator = min;
		while (!finished && iterator <= max) {
			System.out.println(Thread.currentThread().getName() + " " + iterator);
			try {
				Thread.sleep(100 + (int) (Math.random() * 900 + 1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iterator++;
		}

		finished = true;

	}
}
