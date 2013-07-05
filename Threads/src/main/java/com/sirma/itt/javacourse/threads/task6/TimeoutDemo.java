package com.sirma.itt.javacourse.threads.task6;

/**
 * A simple test for the {@link TimeoutHashtable}.
 * 
 * @author user
 */
public final class TimeoutDemo {
	/**
	 * A private constructor, disallowing the instantiation of this class.
	 */
	private TimeoutDemo() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 * @throws InterruptedException
	 *             if sleep of the method is interrupted
	 */
	public static void main(String[] args) throws InterruptedException {
		TimeoutHashtable table = new TimeoutHashtable(5);
		table.put("first", 1);
		table.put("second", 2);
		table.put("third", 50);
		Thread.sleep(500);
		System.out.println("The second element has been added again.. resetting timer");
		table.put("second", 2);
		Thread.sleep(4000);
		table.get("second");
	}
}
