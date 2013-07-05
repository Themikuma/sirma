package com.sirma.itt.javacourse.gui.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * A wrapper for the client class on the server side.
 * 
 * @author user
 */
public class ClientWrapper {
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;

	/**
	 * Setting up the socket and opening the streams of the socket.
	 * 
	 * @param socket
	 *            the socket
	 */
	public ClientWrapper(Socket socket) {
		this.socket = socket;
		try {
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	/**
	 * Getter method for reader.
	 * 
	 * @return the reader
	 */
	public BufferedReader getReader() {
		return reader;
	}

	/**
	 * Setter method for reader.
	 * 
	 * @param reader
	 *            the reader to set
	 */
	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	/**
	 * Close the connection with the client.
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
	 * Send e message to the client.
	 * 
	 * @param message
	 *            the message
	 */
	public void sendMessage(String message) {

		try {
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * receive a message from the client.
	 * 
	 * @return the received message
	 */
	public String receiveMessage() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
