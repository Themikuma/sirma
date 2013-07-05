package com.cit.chat.server;

import java.net.Socket;

public class Client {
	private Socket socket;
	private String username = "";

	/**
	 * @param socket
	 */
	public Client(Socket socket, String name) {
		super();
		this.username = name;
		this.socket = socket;
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
}
