package com.sirma.itt.javacourse.objects;

/**
 * PolyLine class - figure, consisting of lines and arcs.
 * 
 * @author user
 */
public class PolyLine extends Figure {

	private Line oneLine;
	private Arc oneArc;

	/**
	 * Getter method for oneLine.
	 * 
	 * @return the oneLine
	 */
	public Line getOneLine() {
		return oneLine;
	}

	/**
	 * Setter method for oneLine.
	 * 
	 * @param oneLine
	 *            the oneLine to set
	 */
	public void setOneLine(Line oneLine) {
		this.oneLine = oneLine;
	}

	/**
	 * Getter method for oneArc.
	 * 
	 * @return the oneArc
	 */
	public Arc getOneArc() {
		return oneArc;
	}

	/**
	 * Setter method for oneArc.
	 * 
	 * @param oneArc
	 *            the oneArc to set
	 */
	public void setOneArc(Arc oneArc) {
		this.oneArc = oneArc;
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub

	}

}
