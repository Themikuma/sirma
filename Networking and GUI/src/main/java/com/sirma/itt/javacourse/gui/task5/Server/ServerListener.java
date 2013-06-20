package com.sirma.itt.javacourse.gui.task5.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ServerListener implements Runnable {
	private Server server;
	private BufferedReader clientInput;
	private BufferedWriter clientOutput;

	/**
	 * @param server
	 */
	public ServerListener(Server server) {
		super();
		this.server = server;
		try {
			clientInput = new BufferedReader(new InputStreamReader(server.getClientSocket()
					.getInputStream()));
			clientOutput = new BufferedWriter(new OutputStreamWriter(server.getClientSocket()
					.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String msg = null;
		while (!".".equals(msg)) {
			msg = readClientMessage();
			if (msg != null)
				sendReversedMessage(msg);
		}
		try {
			clientInput.close();
			clientOutput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server.getConsole().setText(server.getConsole().getText() + "Client thread destroyed\n");

	}

	// TODO create methods for updating console text
	private String readClientMessage() {
		try {
			String msg = clientInput.readLine();
			server.getConsole().setText(server.getConsole().getText() + "Client: " + msg + "\n");
			return msg;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void sendReversedMessage(String message) {
		try {
			server.getConsole().setText(
					server.getConsole().getText() + "Sending back to client reversed message\n");
			clientOutput.write(new StringBuilder(message).reverse().toString());
			clientOutput.newLine();
			clientOutput.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
