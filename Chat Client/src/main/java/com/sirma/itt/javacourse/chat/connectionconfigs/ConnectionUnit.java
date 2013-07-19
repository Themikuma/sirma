package com.sirma.itt.javacourse.chat.connectionconfigs;


public interface ConnectionUnit {

	public void updateStatus(String status);

	public void start();

	public void tryConnect(String host, String username, int port);

}
