package com.sirma.itt.javacourse.objects.task3;

/**
 * Interface for the customer.
 * 
 * @author user
 */
public interface Customer {

	/**
	 * The client can buy items.
	 * 
	 * @param products
	 *            the list of products, the customer is buying
	 */
	void buyItem(Product[] products);

	/**
	 * The client can pay for an item.
	 * 
	 * @param cost
	 *            the total cost of all the products, the customer is buying
	 */
	void payItem(int cost);

}
