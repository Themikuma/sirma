package com.sirma.itt.javacourse.chat.client.main;

import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.client.maincomponents.SwingClient;
import com.sirma.itt.javacourse.chat.connectionconfigs.ConnectionUnit;
import com.sirma.itt.javacourse.chat.connectionconfigs.DialogConnection;

/**
 * Using the builder pattern to build the client chat window by setting the {@link MainUnit} and
 * {@link ConnectionUnit}. By default the main unit is a {@link SwingClient} and the connection unit
 * is a {@link DialogConnection}.
 * 
 * @author user
 */
public class ClientBuilder {
	private MainUnit mainFrame = new SwingClient();
	private ConnectionUnit connectionFrame = new DialogConnection();

	/**
	 * Set the main unit of the chat client.
	 * 
	 * @param mainFrame
	 *            the unit implementation
	 * @return this so we can continue building
	 */
	public ClientBuilder setMainUnit(MainUnit mainFrame) {
		this.mainFrame = mainFrame;
		return this;
	}

	/**
	 * Set the connection unit of the chat client.
	 * 
	 * @param connectionFrame
	 *            the unit implementation
	 * @return this so we can continue building
	 */
	public ClientBuilder setConnectionFrame(ConnectionUnit connectionFrame) {
		this.connectionFrame = connectionFrame;
		return this;
	}

	/**
	 * Build the client out of the given components. If no components are specified, the default
	 * ones are used.
	 */
	public void build() {
		mainFrame.start();
		// TODO nope
		connectionFrame.setParent(mainFrame);
		connectionFrame.start();
	}
}
