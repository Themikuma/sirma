package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sirma.itt.javacourse.chat.messages.IClientMessages;

/**
 * An example implementation of the {@link ClientMainUnit}, that writes messages to the console.
 * 
 * @author user
 */
public class ConsoleClient extends ClientMainUnit {

	@Override
	public void onUserAdded(String user) {
		System.out.println(user + " has joined");

	}

	@Override
	public void onUserRemoved(String user) {
		System.out.println(user + " has left");

	}

	@Override
	public void start() {
		startConnectionUnit();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + line);
			}
		} catch (IOException e) {
			System.out
					.println("An IO exception occured while trying to read a line from the console");
		}
		disconnect();
	}

	@Override
	public void onServerStopped() {
		System.out.println("Server stopped.");
	}

	@Override
	public void addMessage(String user, String message) {
		System.out.println(user + " : " + message);

	}

}
