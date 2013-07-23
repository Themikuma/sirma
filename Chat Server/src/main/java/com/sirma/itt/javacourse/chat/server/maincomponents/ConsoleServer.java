package com.sirma.itt.javacourse.chat.server.maincomponents;

/**
 * A console implementation of the {@link SwingServer}.
 * 
 * @author user
 */
public class ConsoleServer extends ServerWindow {

	@Override
	public void onClientConnected(String client) {
		System.out.println(client + " has connected");

	}

	@Override
	public void onClientDisconnected(String client) {
		System.out.println(client + " has disconnected");

	}
}
