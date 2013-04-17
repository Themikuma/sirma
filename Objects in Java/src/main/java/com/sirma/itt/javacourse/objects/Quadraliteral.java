package com.sirma.itt.javacourse.objects;

/**
 * Quadrilateral class - a figure with 4 points.
 * 
 * @author user
 */
public class Quadraliteral extends Figure {
	private Point pointOne;
	private Point pointTwo;
	private Point pointThree;
	private Point pointFour;

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
	 * Getter method for pointTwo.
	 * 
	 * @return the pointTwo
	 */
	public Point getPointTwo() {
		return pointTwo;
	}

	/**
	 * Setter method for pointTwo.
	 * 
	 * @param pointTwo
	 *            the pointTwo to set
	 */
	public void setPointTwo(Point pointTwo) {
		this.pointTwo = pointTwo;
	}

	/**
	 * Getter method for pointThree.
	 * 
	 * @return the pointThree
	 */
	public Point getPointThree() {
		return pointThree;
	}

	/**
	 * Setter method for pointThree.
	 * 
	 * @param pointThree
	 *            the pointThree to set
	 */
	public void setPointThree(Point pointThree) {
		this.pointThree = pointThree;
	}

	/**
	 * Getter method for pointFour.
	 * 
	 * @return the pointFour
	 */
	public Point getPointfour() {
		return pointFour;
	}

	/**
	 * Setter method for pointFour.
	 * 
	 * @param pointFour
	 *            the pointFour to set
	 */
	public void setPointFour(Point pointFour) {
		this.pointFour = pointFour;
	}

	/**
	 * A draw method, drawing a figure from the 4 points.
	 */
	@Override
	void draw() {
		// TODO Auto-generated method stub

	}
}
