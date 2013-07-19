package com.sirma.itt.javacourse.chat.client.maincomponents;

import com.sirma.itt.javacourse.chat.structures.Message;
import com.sirma.itt.javacourse.chat.structures.Server;

public interface MainUnit {

	public void start();

	public void startListening(Server server);

	public void addUser(String user);

	public void removeUser(String user);

	public void reloadList(String users);

	public void addMessage(Message message);

	public void stop();
}
