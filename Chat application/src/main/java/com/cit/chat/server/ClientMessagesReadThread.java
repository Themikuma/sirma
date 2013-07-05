package com.cit.chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import javax.swing.JTextArea;

import com.cit.chat.common.IClientMessages;
import com.cit.chat.common.IServerMessages;

public class ClientMessagesReadThread implements Runnable {
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private JTextArea console;
	private List<Client> userList;

	/**
	 * @param socket
	 */
	public ClientMessagesReadThread(Socket socket, JTextArea console, List<Client> userList) {
		super();
		this.socket = socket;
		this.console = console;
		this.userList = userList;
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
			while ((msg = readClientMessage()) != null) {
				String[] splitMessage = msg.split("[|]");

				if (IClientMessages.CONNECTION_ATTEMPT.toString().equals(splitMessage[0])) {
					if (checkLoginMessage(splitMessage[1])) {
						userList.add(new Client(socket, splitMessage[1]));
						writer.write(IServerMessages.NICK_OK.toString());
						writer.newLine();
						writer.flush();
						Thread thread = new Thread(new SendMessageThread(userList,
								IServerMessages.CLIENT_CONNECTED + "|" + splitMessage[1]));
						thread.start();
					}
				}

			}

			socket.close();
		} catch (IOException e) {
			System.out.println("The client has terminated the conection");
		}
		console.setText(console.getText() + "Client thread destroyed\n");

	}

	/**
	 * Read an incomming message from the client.
	 * 
	 * @return the read message
	 * @throws IOException
	 *             if the client has terminated the connection
	 */
	private String readClientMessage() throws IOException {

		String msg = reader.readLine();
		console.setText(console.getText() + "Client: " + msg + "\n");
		return msg;

	}

	private boolean checkLoginMessage(String message) {
		// TODO message shouldnt contain ][
		for (Client client : userList) {
			if (message.equals(client.getUsername()))
				return false;
		}
		return true;
	}
}
