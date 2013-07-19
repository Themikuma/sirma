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

public class UsersManager {
	private Set<Client> clientSet = new LinkedHashSet<>();
	private Executor executor = Executors.newCachedThreadPool();
	private ServerWindow serverWindow;
	private final Pattern pattern = Pattern.compile("\\]|\\[");

	/**
	 * @param console
	 */
	public UsersManager(ServerWindow window) {
		super();
		this.serverWindow = window;
	}

	public void broadcastMessage(String message) {
		synchronized (clientSet) {

			Iterator<Client> iterator = clientSet.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				sendMessage(client, message);
			}
		}
	}

	public void sendMessage(Client client, String message) {
		executor.execute(new SendMessageThread(client, message));
	}

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

	public void removeUser(Client client) {
		serverWindow.disconnected(client.getUsername());
		client.closeConnection();
		clientSet.remove(client);
		broadcastMessage(IServerMessages.CLIENT_DISCONNECTED + "|" + client.getUsername());
	}

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
