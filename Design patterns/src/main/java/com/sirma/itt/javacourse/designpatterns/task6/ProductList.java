package com.sirma.itt.javacourse.designpatterns.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * A class containing common methods for both available and sold product lists.
 * 
 * @author user
 */
public class ProductList {
	private List<String> products = new ArrayList<String>();
	private List<Observer> observers = new ArrayList<Observer>();

	/**
	 * Notify all attached observers that this object has changed.
	 */
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	/**
	 * Attach an observer to this object.
	 * 
	 * @param observer
	 *            the observer to attach to
	 */
	public void attach(Observer observer) {
		observers.add(observer);
	}

	/**
	 * Detach an observer from this object.
	 * 
	 * @param observer
	 *            the observer to detach from
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * Add a product to the object's list of products and notify the observers.
	 * 
	 * @param product
	 *            the product to be added
	 */
	public void addProduct(String product) {
		getProducts().add(product);
		notifyObservers();

	}

	/**
	 * Remove a product from the object's list of products and notify the observers.
	 * 
	 * @param product
	 *            the product to be removed
	 */
	public void removeProduct(String product) {
		getProducts().remove(product);
		notifyObservers();
	}

	/**
	 * Getter method for products.
	 * 
	 * @return the products
	 */
	public List<String> getProducts() {
		return products;
	}

	/**
	 * Setter method for products.
	 * 
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<String> products) {
		this.products = products;
	}

	/**
	 * Getter method for observers.
	 * 
	 * @return the observers
	 */
	public List<Observer> getObservers() {
		return observers;
	}

	/**
	 * Setter method for observers.
	 * 
	 * @param observers
	 *            the observers to set
	 */
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

}
