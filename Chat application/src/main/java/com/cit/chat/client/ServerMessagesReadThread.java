package com.cit.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.cit.chat.common.IServerMessages;
import com.cit.chat.sockets.SocketFinder;

public class ServerMessagesReadThread implements Runnable {

	private String host;
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private LoginForm parent;
	private ClientMainFrame mainWindow;

	/**
	 * Set the host.
	 * 
	 * @param host
	 *            the host to connect to
	 */
	public ServerMessagesReadThread(String host, LoginForm parent, ClientMainFrame mainWindow) {
		this.host = host;
		this.parent = parent;
		this.mainWindow = mainWindow;
	}

	@Override
	public void run() {
		connect();
		try {
			String msg;
			while ((msg = waitForMessage()) != null) {
				System.out.println(msg);
				String[] splitMessage = msg.split("[|]");
				if (IServerMessages.NICK_OK.toString().equals(msg)) {
					parent.dispose();
				} else if (IServerMessages.CLIENT_CONNECTED.toString().equals(splitMessage[0])) {
					mainWindow.getUserListModel().addElement(splitMessage[1]);
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "The server has been stopped");
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Find an available port to connect to and connect to it.
	 */
	public void connect() {
		socket = SocketFinder.getAvailableSocket(host, 7000, 7020);
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Wait for a message from the server.
	 * 
	 * @return the read message
	 * @throws IOException
	 *             if the server has been closed while waiting
	 */
	public String waitForMessage() throws IOException {
		try {
			String line = reader.readLine();
			return line;
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "No available server was found");
		}
		return null;

	}

	/**
	 * Sends the message to the server.
	 * 
	 * @param message
	 *            the message to send.
	 */
	public void sendMessage(String message) {
		try {
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException e1) {

		}

	}

}
