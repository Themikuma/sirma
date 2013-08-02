package com.sirma.itt.javacourse.chat.server.maincomponents;

import java.io.IOException;
import java.util.Locale;

import com.sirma.itt.javacourse.chat.contracts.MainUnit;
import com.sirma.itt.javacourse.chat.server.main.Server;

/**
 * Provides structure of the main units.
 * 
 * @author user
 */
public abstract class ServerMainUnit implements MainUnit {
	private Server server;

	public void startConnectionUnit() {
		if (server.getServer() == null || server.getServer().isClosed())
			server.getConnectionUnit().start();
	}

	public void stopServer() {
		try {
			if (server.getServer() != null && !server.getServer().isClosed())
				server.getServer().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Getter method for server.
	 * 
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * Setter method for server.
	 * 
	 * @param server
	 *            the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public Locale getCurrentLocale() {
		return server.getCurrentLocale();
	}

	@Override
	public void setCurrentLocale(Locale locale) {
		server.setCurrentLocale(locale);
	}

	@Override
	public Locale getLocaleFromIndex(int index) {
		return server.getSupported()[index];
	}
}
