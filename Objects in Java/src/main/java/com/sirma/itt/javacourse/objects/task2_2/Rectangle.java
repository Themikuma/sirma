package com.sirma.itt.javacourse.objects.task2_2;

import com.sirma.itt.javacourse.objects.task2_1.Point;

/**
 * Rectangle class - figure with two pairs of parallel sides positioned at exactly 90 degrees.
 * 
 * @author user
 */
public class Rectangle extends Parallelogram {

	private Point pointOne;
	private int height;
	private int width;

	/**
	 * Constructor of the rectangle class.
	 * 
	 * @param pointOne
	 *            the bottom left point of the rectangle
	 * @param height
	 *            the height of the two parallel sides of the rectangle
	 * @param width
	 *            the widht of the other two parallel sides of the rectangle
	 */
	public Rectangle(Point pointOne, int height, int width) {
		super(pointOne, width, height, 90);
	}

	/**
	 * Getter method for pointOne.
	 * 
	 * @return the pointOne
	 */
	public Point getPointOne() {
		return pointOne;
	}

	/**
	 * Setter method for pointOne.
	 * 
	 * @param pointOne
	 *            the pointOne to set
	 */
	public void setPointOne(Point pointOne) {
		this.pointOne = pointOne;
	}

	/**
	 * Getter method for height.
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Setter method for height.
	 * 
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Getter method for width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Setter method for width.
	 * 
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

}
