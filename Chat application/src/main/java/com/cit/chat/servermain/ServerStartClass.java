package com.cit.chat.servermain;

import javax.swing.SwingUtilities;

import com.cit.chat.server.ServerMainFrame;

public class ServerStartClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ServerMainFrame server = new ServerMainFrame();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				server.initUI();

			}
		});
		server.start();
	}
}
