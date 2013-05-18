package com.sirma.itt.javacourse.objects.task2_2;

import com.sirma.itt.javacourse.objects.task2_1.Point;

/**
 * Rhombus class - figure with 4 sides of equal length with an angle.
 * 
 * @author user
 */
public class Rhombus extends Parallelogram {
	private int sideLength;
	private Point pointOne;
	private int angle;

	/**
	 * Constructor of the rhombus class.
	 * 
	 * @param pointOne
	 *            the bottom left point of the rhombus
	 * @param sideLength
	 *            the length of all the sides of the rhombus
	 * @param angle
	 *            the angle at which the sides are positioned
	 */
	public Rhombus(Point pointOne, int sideLength, int angle) {
		super(pointOne, sideLength, sideLength, angle);
		this.sideLength = sideLength;
		// TODO Auto-generated constructor stub
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
	 * Getter method for angle.
	 * 
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Setter method for angle.
	 * 
	 * @param angle
	 *            the angle to set
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

}
