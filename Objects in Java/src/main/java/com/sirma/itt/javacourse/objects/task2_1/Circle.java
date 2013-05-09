package com.sirma.itt.javacourse.objects.task2_1;


/**
 * Circle class extending the Ellipse class. Every circle is an ellipse. The circle has radius and
 * diameter and inherits the center Point from the ellipse class.
 * 
 * @author user
 */
public class Circle extends Ellipse {

	private int radius;
	private int diameter;

	/**
	 * Class constructor, sets the radius, diameter and the center for the circle.
	 * 
	 * @param center
	 *            center of the circle
	 * @param radius
	 *            radius fo the circle
	 * @param diameter
	 *            diameter of the circle
	 */
	public Circle(Point center, int radius, int diameter) {
		super(center);
		this.setRadius(radius);
		this.setDiameter(diameter);
	}

	/**
	 * Getter method for diameter.
	 * 
	 * @return the diameter
	 */
	public int getDiameter() {
		return diameter;
	}

	/**
	 * Setter method for diameter.
	 * 
	 * @param diameter
	 *            the diameter to set
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
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
