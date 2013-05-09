package com.sirma.itt.javacourse.objects.task2_3;

import com.sirma.itt.javacourse.objects.task2_1.Arc;
import com.sirma.itt.javacourse.objects.task2_1.Point;

/**
 * Line class - The line is an arc with 0 degrees bending.
 * 
 * @author user
 */
public class Line extends Arc {

	/**
	 * The constructor of the line.
	 * 
	 * @param a
	 *            the starting point of the line
	 * @param b
	 *            the end point of the line
	 */
	public Line(Point a, Point b) {
		super(a, b, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}
