package com.sirma.itt.javacourse.gui.sockets;

import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * The interface of the client listeners.
 * 
 * @author user
 */
public abstract class ClientListener implements Runnable {

	private Socket socket;
	private BufferedReader reader;

	/**
	 * Set up the socket connection.
	 * 
	 * @param socket
	 *            the socket
	 */
	public ClientListener(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		connect();
		try {
			String msg = null;
			while ((msg = waitForMessage()) != null) {
				onMessageReceived(msg);
			}
		} catch (IOException e) {
			if (!GraphicsEnvironment.isHeadless())
				JOptionPane.showMessageDialog(null, "The server has been stopped");
			else
				System.out.println("The server has been stopped");
		}
		closeConnection();
	}

	/**
	 * Find an available port to connect to and connect to it.
	 */
	public void connect() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		onConnect();

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
			if (!GraphicsEnvironment.isHeadless())
				JOptionPane.showMessageDialog(null, "No available server was found");
			else
				System.out.println("No available server was found");
		}
		return null;

	}

	/**
	 * Let the user handle what happens on established connection.
	 */
	public abstract void onConnect();

	/**
	 * Let the user handle what happens on message received.
	 * 
	 * @param message
	 *            the received message
	 */
	public abstract void onMessageReceived(String message);

	/**
	 * Getter method for socket.
	 * 
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * Setter method for socket.
	 * 
	 * @param socket
	 *            the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Close the connection with the server.
	 */
	public void closeConnection() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
