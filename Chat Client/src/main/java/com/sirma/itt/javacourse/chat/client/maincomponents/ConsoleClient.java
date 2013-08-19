package com.sirma.itt.javacourse.chat.client.maincomponents;

/**
 * An example implementation of the {@link ClientMainUnit}, that writes messages to the console.
 * 
 * @author user
 */
public final class ConsoleClient extends ClientMainUnit {

	@Override
	public void onConnectionClosed() {
		System.out.println("Disconnected.");

	}

	@Override
	public void onMessageAdded(String arg0, String arg1) {
		System.out.println(arg0 + ":" + arg1);

	}

	@Override
	public void onUserAdded(String arg0) {
		System.out.println(arg0 + " added to list");

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
	public void onError(String arg0) {
		System.out.println(arg0);

	}

	@Override
	public void onUserList(String userList) {
		System.out.println("Current users " + userList);

	}

}
