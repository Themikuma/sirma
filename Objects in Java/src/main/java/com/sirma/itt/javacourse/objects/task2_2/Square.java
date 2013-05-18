package com.sirma.itt.javacourse.objects.task2_2;

import com.sirma.itt.javacourse.objects.task2_1.Point;

/**
 * Square class- figure with 4 equal sides positioned at 90 degrees.
 * 
 * @author user
 */
public class Square extends Rhombus {

	private Point pointOne;
	private int sideLength;

	/**
	 * Constructor class of the square.
	 * 
	 * @param pointOne
	 *            the bottom left point of the square
	 * @param sideLength
	 *            the length of the sides of the square
	 */
	public Square(Point pointOne, int sideLength) {
		super(pointOne, sideLength, 90);
		// TODO Auto-generated constructor stub
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
	 * Getter method for sideLength.
	 * 
	 * @return the sideLength
	 */
	public int getSideLength() {
		return sideLength;
	}

	/**
	 * Setter method for sideLength.
	 * 
	 * @param sideLength
	 *            the sideLength to set
	 */
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

}
