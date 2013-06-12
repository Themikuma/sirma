package com.sirma.itt.javacourse.threads.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Provides methods for starting and stopping a thread, that counts up to a max number and returns
 * the result if it's stopped.
 * 
 * @author user
 */
public class Counter {
	private final CounterThread counter;
	private final Thread counterThread;

	// TODO generate getters and setters for all
	/**
	 * Setting up the maximum number and the thread on which the runnable object will count.
	 * 
	 * @param maxTime
	 *            the number to which the runnable object will count before dying.
	 */
	public Counter(int maxTime) {
		this.counter = new CounterThread(maxTime);
		this.counterThread = new Thread(counter);
	}

	/**
	 * Starts the thread.
	 */
	public void startCounter() {
		counterThread.start();

	}

	/**
	 * Interrupts the thread and gets the number to which the runnable object has counted. The
	 * thread is interrupted when a char symbol is entered in the input stream.
	 * 
	 * @param in
	 *            the {@link InputStream} that is going to wait on an entered char to interrupt the
	 *            thread
	 * @return the number to which the runnable has counted
	 */
	public int stopCounter(InputStream in) {
		try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
			input.read();
			counterThread.interrupt();
			return counter.getSeconds();

		} catch (IOException e) {
			// TODO auto generated
			e.printStackTrace();
		}
		return counter.getSeconds();
	}

	/**
	 * Getter method for counter.
	 * 
	 * @return the counter
	 */
	public CounterThread getCounter() {
		return counter;
	}

	/**
	 * Getter method for counterThread.
	 * 
	 * @return the counterThread
	 */
	public Thread getCounterThread() {
		return counterThread;
	}
}
