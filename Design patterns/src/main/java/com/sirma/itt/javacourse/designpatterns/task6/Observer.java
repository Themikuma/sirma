package com.sirma.itt.javacourse.designpatterns.task6;

/**
 * Interface for all the classes interested in observing another class.
 * 
 * @author user
 */
public interface Observer {
	/**
	 * fired up when a product is added or removed in a {@link ProductList}.
	 * 
	 * @param list
	 *            the list that sent the event
	 */
	void update(ProductList list);
}
