package com.sirma.itt.javacourse.objects;

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
	void draw() {
		// TODO Auto-generated method stub

	}

}
