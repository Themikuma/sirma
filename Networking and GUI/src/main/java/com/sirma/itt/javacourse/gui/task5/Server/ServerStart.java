package com.sirma.itt.javacourse.gui.task5.Server;

import javax.swing.SwingUtilities;

public class ServerStart {

	/**
	 * @param args
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
