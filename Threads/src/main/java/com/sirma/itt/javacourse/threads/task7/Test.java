package com.sirma.itt.javacourse.threads.task7;

/**
 * A simple test class for the {@link Storage}.
 * 
 * @author user
 */
public final class Test {

	/**
	 * A private constructor disallowing the instantiation of the class.
	 */
	private Test() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		Storage storage = new Storage(1);
		Storage.Consumer consumer = storage.new Consumer();
		Storage.Producer producer = storage.new Producer();

		Thread consumerThread = new Thread(consumer);
		Thread producerThread = new Thread(producer);
		Thread consumerThreadTwo = new Thread(consumer);
		consumerThread.start();
		consumerThreadTwo.start();
		producerThread.start();

	}

}
