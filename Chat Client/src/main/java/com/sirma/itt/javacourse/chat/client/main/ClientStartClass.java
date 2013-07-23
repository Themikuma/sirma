package com.sirma.itt.javacourse.chat.client.main;

import com.sirma.itt.javacourse.chat.client.maincomponents.ConsoleClient;
import com.sirma.itt.javacourse.chat.connectionconfigs.DialogConnection;

/**
 * An example use of the chat client.
 * 
 * @author user
 */
public final class ClientStartClass {

	/**
	 * A private constructor, disallowing the instantiation of this class.
	 */
	private ClientStartClass() {

	}

	/**
	 * Building the client via a {@link ClientBuilder}.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {

		ClientBuilder builder = new ClientBuilder();
		builder.setMainUnit(new ConsoleClient()).setConnectionFrame(new DialogConnection()).build();

	}
}
