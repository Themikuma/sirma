package com.cit.chat.server;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerWindow;
import com.sirma.itt.javacourse.chat.server.structures.Client;

/**
 * The Manager of all clients. Handles the addition, removal and messages of users.
 * 
 * @author user
 */
public class UsersManager {
	private Set<Client> clientSet = new LinkedHashSet<>();
	private Executor executor = Executors.newCachedThreadPool();
	private ServerWindow serverWindow;
	private final Pattern pattern = Pattern.compile("\\]|\\[");

	/**
	 * Setting up the main unit.
	 * 
	 * @param window
	 *            the main unit
	 */
	public UsersManager(ServerWindow window) {
		super();
		this.serverWindow = window;
	}

	// TODO is this really thread safe ?
	/**
	 * Broadcast a message to all users.
	 * 
	 * @param message
	 *            the message to be broadcastet
	 */
	public void broadcastMessage(String message) {
		synchronized (clientSet) {

			Iterator<Client> iterator = clientSet.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				sendMessage(client, message);
			}
		}
	}

	/**
	 * Send a message to a single user. Also used when broadcasting messages.
	 * 
	 * @param client
	 *            the client
	 * @param message
	 *            the message to be sent
	 */
	public void sendMessage(Client client, String message) {
		executor.execute(new SendMessageThread(client, message));
	}

	/**
	 * Add a user to the list of users if there is no other user with the same name and if the name
	 * doesn't contain ][.
	 * 
	 * @param client
	 *            the connected client
	 */
	public void addUser(Client client) {
		Matcher matcher = pattern.matcher(client.getUsername());
		if (!clientSet.contains(client) && !matcher.find()) {
			serverWindow.connected(client.getUsername());
			client.sendMessage(IServerMessages.NICK_OK.toString());
			broadcastMessage(IServerMessages.ADD_TO_LIST + "|" + client.getUsername());
			clientSet.add(client);

			sendMessage(client, IServerMessages.USER_LIST + "|" + generateUsernameString());
		} else
			sendMessage(client, IServerMessages.INVALID_NICK.toString());
	}

	/**
	 * Remove a user from the list. Called when an user has disconnected.
	 * 
	 * @param client
	 *            the user that disconnected
	 */
	public void removeUser(Client client) {
		serverWindow.disconnected(client.getUsername());
		client.closeConnection();
		clientSet.remove(client);
		broadcastMessage(IServerMessages.CLIENT_DISCONNECTED + "|" + client.getUsername());
	}

	/**
	 * Generate a string with all users names to send to a new client when he first connects.
	 * 
	 * @return the generated string
	 */
	private String generateUsernameString() {
		String result = "";
		synchronized (clientSet) {

			Iterator<Client> iterator = clientSet.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				result += client.getUsername() + ",";
			}
		}
		return result;
	}
}
