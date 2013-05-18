package com.sirma.itt.javacourse.objects.task2_1;

/**
 * Circle class extending the Ellipse class. Every circle is an ellipse. The circle has radius and
 * diameter and inherits the center Point from the ellipse class.
 * 
 * @author user
 */
public class Circle extends Ellipse {

	private Point center;
	private int radius;

	/**
	 * Class constructor, sets the radius, diameter and the center for the circle.
	 * 
	 * @param center
	 *            center of the circle
	 * @param radius
	 *            radius of the circle
	 */
	public Circle(Point center, int radius) {
		super(center, center, radius, radius);
		this.center = center;
		this.radius = radius;
	}

	/**
	 * Getter method for center.
	 * 
	 * @return the center
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * Setter method for center.
	 * 
	 * @param center
	 *            the center to set
	 */
	public void setCenter(Point center) {
		this.center = center;
	}

	/**
	 * Getter method for radius.
	 * 
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Setter method for radius.
	 * 
	 * @param radius
	 *            the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

}
