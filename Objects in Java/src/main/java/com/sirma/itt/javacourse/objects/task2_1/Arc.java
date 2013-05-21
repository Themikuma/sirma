package com.sirma.itt.javacourse.objects.task2_1;

/**
 * Arc class inheriting the figure class. Contains a point and an angle.
 * 
 * @author user
 */
public class Arc extends Figure {
	private Point a;
	private int angle;
	private int length;

	/**
	 * Class constructor setting the point and the angle of the arc.
	 * 
	 * @param a
	 *            the point of the arc
	 * @param angle
	 *            the angle of the arc
	 * @param length
	 *            the length of the arc
	 */
	public Arc(Point a, int angle, int length) {
		this.setA(a);
		this.setAngle(angle);
		this.setLength(length);
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

	@Override
	public void draw() {

	}

	/**
	 * Getter method for length.
	 * 
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Setter method for length.
	 * 
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
}
