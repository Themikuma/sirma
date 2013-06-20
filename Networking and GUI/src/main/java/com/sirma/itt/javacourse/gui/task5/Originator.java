package com.sirma.itt.javacourse.gui.task5;

public class Originator {

	public String restoreMemento(Memento memento) {
		return memento.getState();
	}

	public Memento saveMemento(String state) {
		return new Memento(state);
	}
}
