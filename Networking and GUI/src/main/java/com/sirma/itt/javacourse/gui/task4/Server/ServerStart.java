package com.sirma.itt.javacourse.gui.task4.Server;

import javax.swing.SwingUtilities;

/**
 * Basic use of the {@link Server}.
 * 
 * @author user
 */
public final class ServerStart {
	/**
	 * Private constructor disallowing the instantiation of this class.
	 */
	private ServerStart() {

	}

	/**
	 * Starting the server.
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
