package com.sirma.itt.javacourse.chat.server.maincomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A console implementation of the {@link SwingServer}.
 * 
 * @author user
 */
public class ConsoleServer extends MainUnit {

	@Override
	public void onClientConnected(String client) {
		System.out.println(client + " has connected");

	}

	@Override
	public void onClientDisconnected(String client) {
		System.out.println(client + " has disconnected");

	}

	@Override
	public void logMessage(String message) {
		System.out.println(message);

	}

	@Override
	public void start() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (!"stop".equals(reader.readLine())) {
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
