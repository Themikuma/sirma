package com.sirma.itt.javacourse.threads.task4;

/**
 * The runnable object which will count from the min number to the max number. When its count
 * increases by 1, it notifies all other objects waiting on the lock object's lock that it's
 * available and starts waiting for some other object to notify it back that the lock object's lock
 * is available once again. This simulates sequential execution.
 * 
 * @author user
 */
public class SynchronizedCounter implements Runnable {
	private final int min;
	private final int max;
	private static Object lock = new Object();
	private static boolean finished;

	/**
	 * Setting up the min and max values.
	 * 
	 * @param min
	 *            the number from which the object is going to count up
	 * @param max
	 *            the number to which the object is going to count
	 */
	public SynchronizedCounter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = min; i < max; i++) {
			if (!finished) {
				System.out.println(Thread.currentThread().getName() + "- " + i);

				synchronized (lock) {
					lock.notifyAll();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

		finished = true;

		synchronized (lock) {
			lock.notifyAll();
		}

	}
}
