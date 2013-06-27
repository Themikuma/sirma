package com.sirma.itt.javacourse.gui.task3.Client;

import javax.swing.SwingUtilities;

/**
 * Basic use of the {@link Client}.
 * 
 * @author user
 */
public final class ClientStart {
	/**
	 * A private constructor disallowing the instantiation of the class.
	 */
	private ClientStart() {

	}

	/**
	 * Main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		final Client client = new Client();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				client.initUI();
			}
		});
		client.startListening();
	}
}
