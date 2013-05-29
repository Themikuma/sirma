package com.sirma.itt.javacourse.designpatterns.task6;

/**
 * An observer, updated when a product is added or removed in the available products list.
 * 
 * @author user
 */
public class AvailableProductsListener implements Observer {

	@Override
	public void update(ProductList list) {
		System.out.println("The available product list has been updated to " + list.getProducts());
	}

}
