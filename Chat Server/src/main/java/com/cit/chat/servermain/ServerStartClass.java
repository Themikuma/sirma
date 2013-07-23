package com.cit.chat.servermain;

import com.cit.chat.server.ServerBuilder;
import com.cit.chat.server.connectionconfigs.DialogConnection;
import com.sirma.itt.javacourse.chat.server.maincomponents.SwingServer;

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
		builder.setMainWindow(new SwingServer()).setConnectionWindow(new DialogConnection())
				.build();
	}
}
