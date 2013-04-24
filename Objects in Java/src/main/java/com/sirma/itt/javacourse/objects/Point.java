package com.sirma.itt.javacourse.objects;

/**
 * @author user
 */
public class Point {
	private int x;
	private int y;

	/**
	 * Constructor of the class. Sets the x and y coordinates of the class.
	 * 
	 * @param x
	 *            the x coordinate of the point
	 * @param y
	 *            the y coordinate of the point
	 */
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Getter method for x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter method for x.
	 * 
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter method for y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter method for y.
	 * 
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
