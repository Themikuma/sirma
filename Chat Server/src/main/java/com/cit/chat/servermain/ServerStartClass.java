package com.cit.chat.servermain;

import com.sirma.itt.javacourse.chat.server.maincomponents.GraphicalServer;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerWindow;

public class ServerStartClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerWindow server = new GraphicalServer();
		server.start();
	}
}
