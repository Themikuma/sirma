package com.sirma.itt.javacourse.gui.task5.Client;

import javax.swing.SwingUtilities;

/**
 * Basic use of the client.
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
	 * Starting the client and connecting to a server.
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
		client.connect();
	}

}
