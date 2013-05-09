package com.sirma.itt.javacourse.objects.task2_2;

import com.sirma.itt.javacourse.objects.task2_1.Point;

/**
 * Rectangle class - figure with two pairs of parallel sides positioned at exactly 90 degrees.
 * 
 * @author user
 */
public class Rectangle extends Parallelogram {

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

}
