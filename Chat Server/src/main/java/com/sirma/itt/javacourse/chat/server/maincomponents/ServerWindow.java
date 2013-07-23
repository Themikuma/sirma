package com.sirma.itt.javacourse.chat.server.maincomponents;

public interface ServerWindow {

	public void connected(String client);

	public void disconnected(String client);

	public void start();

	public void stop();
}
