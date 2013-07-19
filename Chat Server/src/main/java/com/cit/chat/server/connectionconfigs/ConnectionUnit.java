package com.cit.chat.server.connectionconfigs;

public interface ConnectionUnit {
	public void updateStatus(String status);

	public void start();

	public void tryConnect(String host, int port);
}
