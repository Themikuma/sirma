package com.sirma.itt.javacourse.objects;

/**
 * The Worker interface for the workers with 2 methods that every worker will do.
 * 
 * @author user
 */
public interface Worker {
	/**
	 * The worker gets paid.
	 */
	void getPaid();

	/**
	 * The worker does his work.
	 */
	void doWork();
}
