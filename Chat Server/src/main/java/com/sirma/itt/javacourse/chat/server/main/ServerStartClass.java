package com.sirma.itt.javacourse.chat.server.main;

import com.sirma.itt.javacourse.chat.server.connectionconfigs.FileConnection;

/**
 * Example use of the server.
 * 
 * @author user
 */
public final class ServerStartClass {
	/**
	 * Private constructor disallowing the instantiation of the class.
	 */
	private ServerStartClass() {

	}

	/**
	 * Using the {@link ServerBuilder} to construct a server and start it.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		ServerBuilder builder = new ServerBuilder();
		builder.setConnectionUnit(new FileConnection("config.txt")).build();
	}
}
