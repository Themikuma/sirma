package com.sirma.itt.javacourse.objects.task2_1;


/**
 * Arc class inheriting the figure class. Contains 2 points and an angle.
 * 
 * @author user
 */
public class Arc extends Figure {
	private Point a;
	private Point b;
	private int angle;

	/**
	 * Class constructor setting the points and the angle of the arc.
	 * 
	 * @param a
	 *            the first point of the arc
	 * @param b
	 *            the second point of the arc
	 * @param angle
	 *            the angle of the arc
	 */
	public Arc(Point a, Point b, int angle) {
		this.setA(a);
		this.setB(b);
		this.setAngle(angle);
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
		// TODO Auto-generated method stub

	}
}
