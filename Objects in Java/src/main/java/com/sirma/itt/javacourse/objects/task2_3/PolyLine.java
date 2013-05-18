package com.sirma.itt.javacourse.objects.task2_3;

import com.sirma.itt.javacourse.objects.task2_1.Arc;
import com.sirma.itt.javacourse.objects.task2_1.Figure;

/**
 * PolyLine class - figure, consisting of lines and arcs.
 * 
 * @author user
 */
public class PolyLine extends Figure {

	private Line[] lines;
	private Arc[] arcs;

	/**
	 * Setting the lines and the arcs of the polyline.
	 * 
	 * @param lines
	 *            the lines of the polyline
	 * @param arcs
	 *            the arcs of the polyline
	 */
	public PolyLine(Line[] lines, Arc[] arcs) {
		this.lines = lines;
		this.arcs = arcs;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	/**
	 * Getter method for lines.
	 * 
	 * @return the lines
	 */
	public Line[] getLines() {
		return lines;
	}

	/**
	 * Setter method for lines.
	 * 
	 * @param lines
	 *            the lines to set
	 */
	public void setLines(Line[] lines) {
		this.lines = lines;
	}

	/**
	 * Getter method for arcs.
	 * 
	 * @return the arcs
	 */
	public Arc[] getArcs() {
		return arcs;
	}

	/**
	 * Setter method for arcs.
	 * 
	 * @param arcs
	 *            the arcs to set
	 */
	public void setArcs(Arc[] arcs) {
		this.arcs = arcs;
	}

}
