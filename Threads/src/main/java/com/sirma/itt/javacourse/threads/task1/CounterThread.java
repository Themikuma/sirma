package com.sirma.itt.javacourse.threads.task1;

/**
 * The runnable object that is going to be used in a thread to count to the maxCount.
 * 
 * @author user
 */
public class CounterThread implements Runnable {
	private int seconds;
	private final int maxCount;

	/**
	 * Setting up the maxCount.
	 * 
	 * @param maxCount
	 *            the maximum number to which the object will count
	 */
	public CounterThread(int maxCount) {
		this.maxCount = maxCount;
	}

	@Override
	public void run() {
		try {
			for (seconds = 0; seconds < maxCount; seconds++) {
				System.out.println(Thread.currentThread().getName() + " " + seconds);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			return;
			// TODO ?? was ist das??
		}

	}

	/**
	 * Getter method for seconds.
	 * 
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * Setter method for seconds.
	 * 
	 * @param seconds
	 *            the seconds to set
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
