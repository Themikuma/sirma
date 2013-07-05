package com.sirma.itt.javacourse.threads.task7;

import com.sirma.itt.javacourse.threads.task5.ObjectArray;

/**
 * A child of the {@link ObjectArray} adding Producers and Consumers that will add and remove
 * elements.
 * 
 * @author user
 */
public class Storage extends ObjectArray {
	/**
	 * Setting the length of the array.
	 * 
	 * @param length
	 *            the length of the array
	 */
	public Storage(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	/**
	 * A producer that at random intervals will add a product to the storage.
	 * 
	 * @author user
	 */
	public class Producer implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100 + (int) (Math.random() * 900 + 1));

					add(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * A consumer that at random intervals will remove elements from the storage.
	 * 
	 * @author user
	 */
	public class Consumer implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100 + (int) (Math.random() * 900 + 1));

					remove();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}
