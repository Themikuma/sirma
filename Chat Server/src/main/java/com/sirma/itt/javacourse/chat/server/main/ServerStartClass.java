package com.sirma.itt.javacourse.chat.server.main;

/**
 * Example use of the server.
 * 
 * @author user
 */
public final class ServerStartClass {

	/**
	 * A private constructor disallowing the instantiation of this class.
	 */
	private ServerStartClass() {
	}

	/**
	 * Builds the {@link Server} object.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		new Server.ServerBuilder().build();
	}
}
