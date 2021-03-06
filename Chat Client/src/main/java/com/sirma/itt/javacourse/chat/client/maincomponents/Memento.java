package com.sirma.itt.javacourse.chat.client.maincomponents;

/**
 * The memento. Contains the state of a given object at a given time.
 * 
 * @author user
 */
public final class Memento {
	private final String state;

	/**
	 * Setting up the state.
	 * 
	 * @param state
	 *            the state to be set.
	 */
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

}
