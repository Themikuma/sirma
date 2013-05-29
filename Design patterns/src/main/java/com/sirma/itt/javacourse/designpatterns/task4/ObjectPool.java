package com.sirma.itt.javacourse.designpatterns.task4;

import java.util.Stack;

/**
 * Class implementing the object pool pattern.
 * 
 * @author user
 */
public class ObjectPool {
	private Stack<String> pool;
	private int maxNumOfObjects;
	private int numOfObjects;

	/**
	 * Setting the maximum number of objects to be pulled from the pool.
	 * 
	 * @param maxNumOfObjects
	 *            the max number of objects
	 */
	public ObjectPool(int maxNumOfObjects) {
		pool = new Stack<String>();
		numOfObjects = 0;
		this.maxNumOfObjects = maxNumOfObjects;
	}

	/**
	 * Get an object from the pool. Since we dont have a createinstance method, we check if the pool
	 * is empty and if it is we return a new instance of the object.
	 * 
	 * @return a new string if the pool is empty or the first element in the stack if it's not.
	 */
	public String acquire() {
		if (numOfObjects == maxNumOfObjects) {
			throw new IndexOutOfBoundsException("Max number of objects reached");
		} else if (pool.isEmpty()) {
			numOfObjects++;
			return new String();
		}
		return pool.pop();
	}

	/**
	 * Returns the object back to the pool and decreases the number of the acquired objects.
	 * 
	 * @param obj
	 *            the object to be returned to the pool
	 */
	public void release(String obj) {
		if (numOfObjects > 0) {
			numOfObjects--;
			pool.add(obj);
		}
	}

	/**
	 * Getter method for pool.
	 * 
	 * @return the pool
	 */
	public Stack<String> getPool() {
		return pool;
	}

	/**
	 * Setter method for pool.
	 * 
	 * @param pool
	 *            the pool to set
	 */
	public void setPool(Stack<String> pool) {
		this.pool = pool;
	}

	/**
	 * Getter method for maxNumOfObjects.
	 * 
	 * @return the maxNumOfObjects
	 */
	public int getMaxNumOfObjects() {
		return maxNumOfObjects;
	}

	/**
	 * Setter method for maxNumOfObjects.
	 * 
	 * @param maxNumOfObjects
	 *            the maxNumOfObjects to set
	 */
	public void setMaxNumOfObjects(int maxNumOfObjects) {
		this.maxNumOfObjects = maxNumOfObjects;
	}

	/**
	 * Getter method for numOfObjects.
	 * 
	 * @return the numOfObjects
	 */
	public int getNumOfObjects() {
		return numOfObjects;
	}

	/**
	 * Setter method for numOfObjects.
	 * 
	 * @param numOfObjects
	 *            the numOfObjects to set
	 */
	public void setNumOfObjects(int numOfObjects) {
		this.numOfObjects = numOfObjects;
	}
}
