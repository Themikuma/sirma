package com.sirma.itt.javacourse.threads.task4;

/**
 * The runnable object which will count from the min number to the max number. When its count
 * increases by 1, it notifies all other objects waiting on the lock object's lock that it's
 * available and starts waiting for some other object to notify it back that the lock object's lock
 * is available once again. This simulates sequential execution.
 * 
 * @author user
 */
public class SynchronizedCounterObject {
	private Object lock = new Object();
	private boolean finished;

	/**
	 * Getter method for lock.
	 * 
	 * @return the lock
	 */
	public Object getLock() {
		return lock;
	}

	/**
	 * Setter method for lock.
	 * 
	 * @param lock
	 *            the lock to set
	 */
	public void setLock(Object lock) {
		this.lock = lock;
	}

	/**
	 * Getter method for finished.
	 * 
	 * @return the finished
	 */
	public synchronized boolean isFinished() {
		return finished;
	}

	/**
	 * Setter method for finished.
	 * 
	 * @param finished
	 *            the finished to set
	 */
	public synchronized void setFinished(boolean finished) {
		this.finished = finished;
	}
}
