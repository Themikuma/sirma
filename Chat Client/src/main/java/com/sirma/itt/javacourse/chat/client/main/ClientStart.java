package com.sirma.itt.javacourse.chat.client.main;

import com.sirma.itt.javacourse.chat.client.maincomponents.ConsoleClient;
import com.sirma.itt.javacourse.chat.connectionconfigs.DialogConnection;

/**
 * An example use of the builder.
 * 
 * @author user
 */
public final class ClientStart {

	/**
	 * Disallowing the instantiation of this class.
	 */
	private ClientStart() {

	}

	/**
	 * Creating the builder and the client object.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		ClientBuilder builder = new ClientBuilder();
		@SuppressWarnings("unused")
		Client client = builder.build();
		client.tryConnect("", "main", "7000");
		for (int i = 0; i < 2000; i++) {
			Client another = builder.setConnectionFrame(new DialogConnection())
					.setMainUnit(new ConsoleClient()).build();
			another.tryConnect("", "asd" + i, "7000");
		}
	}
}
