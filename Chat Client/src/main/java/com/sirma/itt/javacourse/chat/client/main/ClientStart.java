package com.sirma.itt.javacourse.chat.client.main;

import java.io.IOException;

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
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ClientBuilder builder = new ClientBuilder();
		@SuppressWarnings("unused")
		Client client = builder.build();
	}
}
