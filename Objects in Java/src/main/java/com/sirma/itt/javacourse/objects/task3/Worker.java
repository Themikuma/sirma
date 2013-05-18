package com.sirma.itt.javacourse.objects.task3;

/**
 * The Worker interface for the workers with 2 methods that every worker will do.
 * 
 * @author user
 */
public interface Worker {
	/**
	 * The worker gets paid.
	 * 
	 * @param salary
	 *            the salary he gets paid
	 */
	void getPaid(int salary);

	/**
	 * The worker does his work.
	 * 
	 * @param work
	 *            the work he has to do
	 */
	void doWork(Object work);
}
