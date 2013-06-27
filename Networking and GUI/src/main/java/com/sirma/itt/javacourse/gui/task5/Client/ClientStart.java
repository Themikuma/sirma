package com.sirma.itt.javacourse.gui.task5.Client;

import javax.swing.SwingUtilities;

public class ClientStart {

	/**
	 * @param args
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
