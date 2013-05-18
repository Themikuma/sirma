package com.sirma.itt.javacourse.objects.task2_3;

import com.sirma.itt.javacourse.objects.task2_1.Arc;
import com.sirma.itt.javacourse.objects.task2_1.Point;

/**
 * Line class - The line is an arc with 0 degrees bending.
 * 
 * @author user
 */
public class Line extends Arc {
	private Point a;
	private Point b;

	/**
	 * The constructor of the line.
	 * 
	 * @param a
	 *            the starting point of the line
	 * @param b
	 *            the end point of the line
	 */
	public Line(Point a, Point b) {
		super(a, 0, (int) Math.sqrt(((a.getX() - b.getX()) * (a.getX() - b.getX()))
				- ((a.getY() - b.getY()) * (a.getY() - b.getY()))));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	/**
	 * Getter method for a.
	 * 
	 * @return the a
	 */
	public Point getA() {
		return a;
	}

	/**
	 * Setter method for a.
	 * 
	 * @param a
	 *            the a to set
	 */
	public void setA(Point a) {
		this.a = a;
	}

	/**
	 * Getter method for b.
	 * 
	 * @return the b
	 */
	public Point getB() {
		return b;
	}

	/**
	 * Setter method for b.
	 * 
	 * @param b
	 *            the b to set
	 */
	public void setB(Point b) {
		this.b = b;
	}

}
