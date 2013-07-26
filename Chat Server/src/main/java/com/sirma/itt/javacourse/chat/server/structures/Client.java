package com.sirma.itt.javacourse.chat.server.structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.sirma.itt.javacourse.chat.server.MessageSender;

/**
 * A wrapper of the object, representing a client.
 * 
 * @author user
 */
public class Client {

	private Socket socket;
	private String username = "";
	private BufferedReader reader;
	private BufferedWriter writer;
	private MessageSender sender;

	/**
	 * Setting up the socket and the name.
	 * 
	 * @param socket
	 *            the socket representing the connection to the client
	 * @param name
	 *            the username of the client
	 */
	public Client(Socket socket, String name) {
		super();
		this.username = name;
		this.socket = socket;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			setWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender = new MessageSender(this);
		Thread thread = new Thread(sender);
		thread.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Client anotherClient = (Client) obj;
		return this.username.equals(anotherClient.username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.username.hashCode();
	}

	/**
	 * Sends a message to the client.
	 * 
	 * @param message
	 *            the message to be sent
	 */
	public void sendMessage(String message) {
		sender.addMessage(message);
	}

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
	 * Getter method for username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for username.
	 * 
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Close the established connection.
	 */
	public void closeConnection() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Wait for a message from the client.
	 * 
	 * @return the read message
	 */
	public String readMessage() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Getter method for writer.
	 * 
	 * @return the writer
	 */
	public BufferedWriter getWriter() {
		return writer;
	}

	/**
	 * Setter method for writer.
	 * 
	 * @param writer
	 *            the writer to set
	 */
	public void setWriter(BufferedWriter writer) {
		this.writer = writer;
	}
}
