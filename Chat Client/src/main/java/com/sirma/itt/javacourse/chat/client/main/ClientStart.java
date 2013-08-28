package com.sirma.itt.javacourse.chat.client.main;


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
		new Client.Builder().build();
		// new Client.Builder().setConnectionFrame(new FileConnection("config.txt"))
		// .setMainUnit(new ConsoleClient()).build();
	}
}
