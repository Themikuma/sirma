package com.sirma.itt.javacourse.threads.task6;

import java.util.HashMap;
import java.util.Map;

/**
 * A Hash table which stores elements for the specified amount of time. Each element has its own
 * timer and accessing that element in any way (adding or retrieving the element) resets it's timer.
 * 
 * @author user
 */
public class TimeoutHashtable {
	private Map<String, Object> table = new HashMap<>();
	private Map<String, Integer> tableTimes = new HashMap<>();
	private final int time;
	private ObjectTimer timer = new ObjectTimer();
	private Thread timerThread = new Thread(timer);

	/**
	 * Sets the time limit of the elements and starts the timer thread.
	 * 
	 * @param time
	 *            the timer thread
	 */
	public TimeoutHashtable(int time) {
		this.time = time;
		timerThread.start();
	}

	/**
	 * Puts an object in the map and in the timer map.
	 * 
	 * @param key
	 *            the key of the object
	 * @param value
	 *            the object
	 */
	public void put(final String key, Object value) {
		table.put(key, value);
		tableTimes.put(key, 0);
	}

	/**
	 * Gets an object from the map from it's key.
	 * 
	 * @param key
	 *            the key of the object to be retrieved.
	 * @return the object
	 */
	public Object get(String key) {
		if (table.containsKey(key)) {
			System.out.println("The " + key + " element has been retrieved... resetting timer");
			tableTimes.put(key, 0);
			return table.get(key);
		}
		return null;
	}

	/**
	 * Removes an object from the map and the timer map.
	 * 
	 * @param key
	 *            the key of the object to be removed
	 */
	public void remove(String key) {
		table.remove(key);
		tableTimes.remove(key);
	}

	/**
	 * The Runnable object that traverses the map, increases the time of each element and deletes
	 * them if necessary.
	 * 
	 * @author user
	 */
	private class ObjectTimer implements Runnable {

		@Override
		public void run() {
			while (true) {
				for (String key : tableTimes.keySet()) {
					if (tableTimes.get(key) == time) {
						remove(key);
						System.out.println(key + " has been removed");
						break;
					} else {
						tableTimes.put(key, tableTimes.get(key) + 1);
						System.out.println(tableTimes.get(key) + " seconds elapsed from " + key
								+ " element insertion");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}

	}
}
