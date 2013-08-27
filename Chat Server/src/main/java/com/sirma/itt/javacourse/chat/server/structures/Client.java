package com.sirma.itt.javacourse.chat.server.structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.threads.MessageSender;

/**
 * A wrapper of the object, representing a client.
 * 
 * @author user
 */
public final class Client {

	private final Socket socket;
	private String username = "default";
	private boolean verified;
	private BufferedReader reader;
	private PrintWriter writer;
	private MessageSender sender;
	private final Server server;
	private Thread senderThread;

	/**
	 * Setting up the socket.
	 * 
	 * @param socket
	 *            the socket representing the connection to the client
	 * @param server
	 *            the main server object
	 */
	public Client(Socket socket, Server server) {
		super();
		this.socket = socket;
		this.server = server;

	}

	/**
	 * Open the socket's streams.
	 * 
	 * @throws IOException
	 *             an io exception occured while trying to open the socket's streams
	 */
	public void openStreams() throws IOException {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintWriter(socket.getOutputStream(), true);
	}

	/**
	 * Start the sender thread.
	 */
	public void startSenderThread() {
		sender = new MessageSender(writer);
		senderThread = new Thread(sender);
		senderThread.setName("Sender thread:" + this.hashCode());
		senderThread.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {

		Client anotherClient = (Client) obj;
		return username.equals(anotherClient.username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.getUsername().hashCode();
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
			senderThread.interrupt();
		} catch (IOException e) {
			server.getMainUnit().onError("clientClose");
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
	 * Getter method for verified.
	 * 
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * Setter method for verified.
	 * 
	 * @param verified
	 *            the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
}
