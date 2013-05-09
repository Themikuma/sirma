package com.sirma.itt.javacourse.objects.task2_1;


/**
 * Ellipse class- extends the Figure class and contains only a center point.
 * 
 * @author user
 */
public class Ellipse extends Figure {

	private Point center;

	/**
	 * Class constructor setting the center of the Ellipse.
	 * 
	 * @param center
	 *            the center of the ellipse
	 */
	public Ellipse(Point center) {
		this.setCenter(center);
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

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
