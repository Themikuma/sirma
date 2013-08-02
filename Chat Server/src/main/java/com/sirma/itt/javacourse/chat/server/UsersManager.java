package com.sirma.itt.javacourse.chat.server;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.server.structures.Client;

/**
 * The Manager of all clients. Handles the addition, removal and messages of users.
 * 
 * @author user
 */
public class UsersManager {
	private Set<Client> clientSet = new LinkedHashSet<>();
	private static final Pattern pattern = Pattern.compile("\\]|\\[");
	private static final String USER_SEPARATOR = ",";

	/**
	 * Broadcast a message to all users.
	 * 
	 * @param message
	 *            the message to be broadcasted
	 */
	public void broadcastMessage(String message) {
		synchronized (clientSet) {
			Iterator<Client> iterator = clientSet.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				System.out.println(client + "\\" + message);
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
	public void sendMessage(final Client client, final String message) {
		client.sendMessage(message);
	}

	/**
	 * Add a user to the list of users if there is no other user with the same name and if the name
	 * doesn't contain ][.
	 * 
	 * @param client
	 *            the connected client
	 * @return true if the user has been added, false otherwise
	 */
	public boolean addUser(Client client) {
		Matcher matcher = pattern.matcher(client.getUsername());
		return !matcher.find() && clientSet.add(client);
	}

	/**
	 * Remove a user from the list. Called when an user has disconnected.
	 * 
	 * @param client
	 *            the user that disconnected
	 */
	public void removeUser(Client client) {
		client.closeConnection();
		synchronized (clientSet) {
			clientSet.remove(client);
		}
		broadcastMessage(IServerMessages.CLIENT_DISCONNECTED + "|" + client.getUsername());
	}

	/**
	 * Generate a string with all users names expect the one of the sender to send to a new client
	 * when he first connects.
	 * 
	 * @param sender
	 *            the sender
	 * @return the generated string
	 */

	public String generateUsernameString(Client sender) {
		String result = "";
		synchronized (clientSet) {

			Iterator<Client> iterator = clientSet.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				if (client != sender)
					result += client.getUsername() + USER_SEPARATOR;
			}
		}
		return result;
	}

	/**
	 * Getter method for clientSet.
	 * 
	 * @return the clientSet
	 */
	public Set<Client> getClientSet() {
		return clientSet;
	}
}
