package com.cit.chat.clientmain;

import javax.swing.SwingUtilities;

import com.cit.chat.client.ClientMainFrame;

public class ClientStartClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final ClientMainFrame mainFrame = new ClientMainFrame();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				mainFrame.initUI();

			}
		});
		mainFrame.start();
	}
}
