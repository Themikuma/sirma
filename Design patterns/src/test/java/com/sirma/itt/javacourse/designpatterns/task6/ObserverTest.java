package com.sirma.itt.javacourse.designpatterns.task6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Observer pattern.
 * 
 * @author user
 */
public class ObserverTest {
	private ProductList availableProducts;
	private Observer observer;

	/**
	 * Setting up the available products list and the test observer before each test.
	 * 
	 * @throws Exception
	 *             if something goes wrong
	 */
	@Before
	public void setUp() throws Exception {
		availableProducts = new AvailableProducts();
		observer = new TestListener();
	}

	/**
	 * Testing the attachment of a new observer.
	 */
	@Test
	public void testAttach() {
		availableProducts.attach(observer);
		assertTrue(availableProducts.getObservers().get(0) != null);
	}

	/**
	 * Testing the detachment of an observer.
	 */
	@Test
	public void testDetach() {
		availableProducts.attach(observer);
		availableProducts.detach(observer);
		assertTrue(availableProducts.getObservers().size() == 0);
	}

	/**
	 * Testing to see if the test observer has been updated properly.
	 */
	@Test
	public void testNotify() {
		availableProducts.attach(observer);
		assertFalse(((TestListener) observer).isUpdated());
		availableProducts.addProduct("hi");
		assertTrue(((TestListener) observer).isUpdated());
	}
}
