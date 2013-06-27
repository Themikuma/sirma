package com.sirma.itt.javacourse.gui.task4.Client;

import javax.swing.SwingUtilities;

/**
 * Basic use of the {@link Client}.
 * 
 * @author user
 */
public final class ClientStart {
	/**
	 * Private constructor disallowing the instantiation of the class.
	 */
	private ClientStart() {

	}

	/**
	 * Starting the client.
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
	}
}
