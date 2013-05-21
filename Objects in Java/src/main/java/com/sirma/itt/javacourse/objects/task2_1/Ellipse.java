package com.sirma.itt.javacourse.objects.task2_1;

/**
 * Ellipse class- extends the Figure class and contains only a center point.
 * 
 * @author user
 */
public class Ellipse extends Figure {

	private Point firstCenter;
	private Point secondCenter;
	private int firstRadius;
	private int secondRadius;

	/**
	 * Setting the ellipse elements.
	 * 
	 * @param firstCenter
	 *            the first foci of the ellipse
	 * @param secondCenter
	 *            the second foci of the ellipse
	 * @param firstRadius
	 *            the minor radius of the ellipse
	 * @param secondRadius
	 *            the major radius of the ellipse
	 */
	public Ellipse(Point firstCenter, Point secondCenter, int firstRadius, int secondRadius) {
		this.firstCenter = firstCenter;
		this.secondCenter = secondCenter;
		this.firstRadius = firstRadius;
		this.secondRadius = secondRadius;

	}

	@Override
	public void draw() {

	}

	/**
	 * Getter method for secondCenter.
	 * 
	 * @return the secondCenter
	 */
	public Point getSecondCenter() {
		return secondCenter;
	}

	/**
	 * Setter method for secondCenter.
	 * 
	 * @param secondCenter
	 *            the secondCenter to set
	 */
	public void setSecondCenter(Point secondCenter) {
		this.secondCenter = secondCenter;
	}

	/**
	 * Getter method for firstCenter.
	 * 
	 * @return the firstCenter
	 */
	public Point getFirstCenter() {
		return firstCenter;
	}

	/**
	 * Setter method for firstCenter.
	 * 
	 * @param firstCenter
	 *            the firstCenter to set
	 */
	public void setFirstCenter(Point firstCenter) {
		this.firstCenter = firstCenter;
	}

	/**
	 * Getter method for firstRadius.
	 * 
	 * @return the firstRadius
	 */
	public int getFirstRadius() {
		return firstRadius;
	}

	/**
	 * Setter method for firstRadius.
	 * 
	 * @param firstRadius
	 *            the firstRadius to set
	 */
	public void setFirstRadius(int firstRadius) {
		this.firstRadius = firstRadius;
	}

	/**
	 * Getter method for secondRadius.
	 * 
	 * @return the secondRadius
	 */
	public int getSecondRadius() {
		return secondRadius;
	}

	/**
	 * Setter method for secondRadius.
	 * 
	 * @param secondRadius
	 *            the secondRadius to set
	 */
	public void setSecondRadius(int secondRadius) {
		this.secondRadius = secondRadius;
	}
}
