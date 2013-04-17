package com.sirma.itt.javacourse.objects;

/**
 * A Parallelogram - figure with two pairs of parallel sides positioned at a certain angle.
 * 
 * @author user
 */
public class Parallelogram extends Quadraliteral {
	private int height;
	private int width;
	private int angle;

	/**
	 * Constructor for the Parallelogram.
	 * 
	 * @param pointOne
	 *            the bottom left point of the parallelogram
	 * @param width
	 *            the width of the parallelogram
	 * @param height
	 *            the height of the parallelogram
	 * @param angle
	 *            the angle of the parallelogram
	 */
	public Parallelogram(Point pointOne, int width, int height, int angle) {
		super();
		this.height = height;
		this.width = width;
		this.angle = angle;
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

}
