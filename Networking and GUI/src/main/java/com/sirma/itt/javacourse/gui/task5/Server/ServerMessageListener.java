package com.sirma.itt.javacourse.gui.task5.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerMessageListener implements Runnable {
	private Socket socket;
	private JTextArea console;
	private BufferedReader reader;
	private BufferedWriter writer;

	/**
	 * @param socket
	 */
	public ServerMessageListener(Socket socket, JTextArea console) {
		super();
		this.socket = socket;
		this.console = console;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		String msg = null;
		try {
			while (!".".equals(msg)) {
				msg = readClientMessage();
				sendReversedMessage(msg);

			}

			socket.close();
		} catch (IOException e) {
			System.out.println("The client has terminated the conection");
		}
		console.setText(console.getText() + "Client thread destroyed\n");

	}

	private String readClientMessage() throws IOException {

		String msg = reader.readLine();
		console.setText(console.getText() + "Client: " + msg + "\n");
		return msg;

	}

	// TODO add a welcome msg
	private void sendReversedMessage(String message) {
		try {
			console.setText(console.getText() + "Sending back to client reversed message\n");
			writer.write(new StringBuilder(message).reverse().toString());
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
