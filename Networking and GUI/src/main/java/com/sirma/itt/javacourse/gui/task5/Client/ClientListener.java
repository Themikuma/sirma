package com.sirma.itt.javacourse.gui.task5.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientListener implements Runnable {

	private Client client;

	/**
	 * @param client
	 */
	public ClientListener(Client client) {
		this.client = client;
	}

	@Override
	public void run() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getSocket()
				.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				client.getConsole().setText(client.getConsole().getText() + line + "\n");
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
