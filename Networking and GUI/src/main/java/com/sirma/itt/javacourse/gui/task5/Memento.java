package com.sirma.itt.javacourse.gui.task5;

public class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	/**
	 * Getter method for state.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter method for state.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		state = state;
	}

}
