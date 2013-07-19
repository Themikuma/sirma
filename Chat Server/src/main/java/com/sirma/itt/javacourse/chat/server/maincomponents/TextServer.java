package com.sirma.itt.javacourse.chat.server.maincomponents;

import javax.swing.JOptionPane;

import com.cit.chat.server.ServerMainThread;

public class TextServer implements ServerWindow {

	@Override
	public void connected(String client) {
		System.out.println(client + " has connected");

	}

	@Override
	public void disconnected(String client) {
		System.out.println(client + " has disconnected");

	}

	@Override
	public void start() {
		Thread thread = new Thread(new ServerMainThread(JOptionPane.showInputDialog("Host"), 8007,
				this));
		thread.start();
	}

}
