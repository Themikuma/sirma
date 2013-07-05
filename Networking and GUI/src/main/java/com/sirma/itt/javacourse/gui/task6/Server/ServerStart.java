package com.sirma.itt.javacourse.gui.task6.Server;

import javax.swing.SwingUtilities;

/**
 * Basic use of the server.
 * 
 * @author user
 */
public final class ServerStart {
	/**
	 * Private constructor disallowing the instantiation of the class.
	 */
	private ServerStart() {

	}

	/**
	 * Start the server and start listening for clients.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		final Server server = new Server();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				server.initUI();
			}
		});
		server.startListening();
	}

}
