package com.cit.chat.client;

import com.sirma.itt.javacourse.chat.structures.Server;

public interface Observer {
	public void update(Server server, String status);
}
