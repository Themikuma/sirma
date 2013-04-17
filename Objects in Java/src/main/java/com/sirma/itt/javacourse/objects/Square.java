package com.sirma.itt.javacourse.objects;

/**
 * Square class- figure with 4 equal sides positioned at 90 degrees.
 * 
 * @author user
 */
public class Square extends Rhombus {

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

}
