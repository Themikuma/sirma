package com.sirma.itt.javacourse.designpatterns.task6;

/**
 * An observer, updated when a product has been added or removed from the sold products list.
 * 
 * @author user
 */
public class SoldProductsListener implements Observer {

	@Override
	public void update(ProductList list) {
		System.out.println("The sold product list has been updated to " + list.getProducts());
	}

}
