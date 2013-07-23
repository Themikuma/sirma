package com.cit.chat.servermain;

import com.cit.chat.server.ServerBuilder;
import com.cit.chat.server.connectionconfigs.DialogConnection;
import com.sirma.itt.javacourse.chat.server.maincomponents.GraphicalServer;

/**
 * Example use of the server.
 * 
 * @author user
 */
public class ServerStartClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerBuilder builder = new ServerBuilder();
		builder.setMainWindow(new GraphicalServer()).setConnectionWindow(new DialogConnection())
				.build();
	}
}
