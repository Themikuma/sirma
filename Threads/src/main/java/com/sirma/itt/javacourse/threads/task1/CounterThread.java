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
			Thread currentThread = Thread.currentThread();
			while (seconds < maxCount || currentThread.isInterrupted()) {
				System.out.println(currentThread.getName() + " " + seconds);
				Thread.sleep(1000);
				seconds++;
			}

		} catch (InterruptedException e) {
			return;
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
