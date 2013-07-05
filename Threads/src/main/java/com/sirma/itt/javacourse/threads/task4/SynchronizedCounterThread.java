package com.sirma.itt.javacourse.threads.task4;

/**
 * The runnable object which will count from the min number to the max number. When its count
 * increases by 1, it notifies all other objects waiting on the lock object's lock that it's
 * available and starts waiting for some other object to notify it back that the lock object's lock
 * is available once again. This simulates sequential execution.
 * 
 * @author user
 */
public class SynchronizedCounterThread implements Runnable {
	private int min;
	private final int max;
	private SynchronizedCounterObject counter;

	/**
	 * Setting up the min,max and counter values.
	 * 
	 * @param min
	 *            the min value
	 * @param max
	 *            the max value
	 * @param counter
	 *            the counter object containing the lock object and the finished boolean
	 */
	public SynchronizedCounterThread(int min, int max, SynchronizedCounterObject counter) {
		this.counter = counter;
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {

		while (!counter.isFinished() && min < max) {
			System.out.println(Thread.currentThread().getName() + "- " + min++);

			synchronized (counter.getLock()) {
				counter.getLock().notifyAll();
				try {
					counter.getLock().wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		synchronized (counter.getLock()) {
			counter.setFinished(true);
			counter.getLock().notifyAll();

		}

	}
}
