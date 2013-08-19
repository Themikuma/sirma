package com.sirma.itt.javacourse.chat.server.maincomponents;

/**
 * A console implementation of the {@link SwingServer}.
 * 
 * @author user
 */
public final class ConsoleServer extends ServerMainUnit {

	@Override
	public void onConnectionClosed() {
		System.out.println("Connection closed");

	}

	@Override
	public void onMessageAdded(String arg0, String arg1) {
		System.out.println(arg0 + ":" + arg1);

	}

	@Override
	public void onUserAdded(String arg0) {
		System.out.println(arg0 + " has connected");

	}

	@Override
	public void onUserRemoved(String arg0) {
		System.out.println(arg0 + " has disconnected");

	}

	@Override
	public void start() {
		startConnectionUnit();

	}

	@Override
	public void onConnectionEstablished(String port) {
		System.out.println("Server started on port " + port);
	}

	@Override
	public void onError(String arg0) {
		System.out.println(arg0);

	}

}
