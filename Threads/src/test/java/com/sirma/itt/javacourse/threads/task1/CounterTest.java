package com.sirma.itt.javacourse.threads.task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.Test;

/**
 * Testing the counter class.
 * 
 * @author user
 */
public class CounterTest {

	/**
	 * Testing the stop counter method. We are turning the timer on, waiting for 3 seconds then
	 * passing a char symbol to the stopCounter method (which requires some kind of input).
	 * 
	 * @throws InterruptedException
	 *             if the 3 second sleep of this thread is interrupted
	 */
	@Test
	public void testStopCounter() throws InterruptedException {
		ByteArrayInputStream input = new ByteArrayInputStream("a".getBytes());
		Counter counter = new Counter(10);
		counter.startCounter();
		Thread.sleep(3000);
		assertEquals(3, counter.stopCounter(input));
	}

	/**
	 * Testing to see if the thread is actually being interrupted.
	 */
	@Test
	public void testInterrupted() {
		ByteArrayInputStream input = new ByteArrayInputStream("a".getBytes());
		Counter counter = new Counter(10);
		counter.startCounter();
		counter.stopCounter(input);
		assertTrue(counter.getCounterThread().isInterrupted());

	}
}
