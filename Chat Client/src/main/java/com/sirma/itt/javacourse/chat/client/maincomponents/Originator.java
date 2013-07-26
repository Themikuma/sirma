package com.sirma.itt.javacourse.chat.client.maincomponents;

/**
 * The only one that will have access to the saved states.
 * 
 * @author user
 */
public class Originator {

	/**
	 * Restore a state from the given {@link Memento}.
	 * 
	 * @param memento
	 *            the memento to restore the state from
	 * @return the restored state
	 */
	public String restoreMemento(Memento memento) {
		return memento.getState();
	}

	/**
	 * Save the state by creating a new {@link Memento}.
	 * 
	 * @param state
	 *            the state to be saved
	 * @return the saved state
	 */
	public Memento saveMemento(String state) {
		return new Memento(state);
	}
}
