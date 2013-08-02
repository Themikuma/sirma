package com.sirma.itt.javacourse.chat.client.main;

import com.sirma.itt.javacourse.chat.client.maincomponents.ClientMainUnit;
import com.sirma.itt.javacourse.chat.client.maincomponents.SwingClient;
import com.sirma.itt.javacourse.chat.connectionconfigs.ClientConnectionUnit;
import com.sirma.itt.javacourse.chat.connectionconfigs.DialogConnection;

/**
 * Using the builder pattern to build the client chat window by setting the {@link ClientMainUnit} and
 * {@link ClientConnectionUnit}. By default the main unit is a {@link SwingClient} and the connection unit
 * is a {@link DialogConnection}.
 * 
 * @author user
 */
public class ClientBuilder {
	private ClientMainUnit mainFrame = new SwingClient();
	private ClientConnectionUnit connectionFrame = new DialogConnection();

	/**
	 * Set the main unit of the chat client.
	 * 
	 * @param mainFrame
	 *            the unit implementation
	 * @return this so we can continue building
	 */
	public ClientBuilder setMainUnit(ClientMainUnit mainFrame) {
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
	public ClientBuilder setConnectionFrame(ClientConnectionUnit connectionFrame) {
		this.connectionFrame = connectionFrame;
		return this;
	}

	/**
	 * Build the client out of the given components. If no components are specified, the default
	 * ones are used.
	 * 
	 * @return the newly created Client object
	 */
	public Client build() {
		return new Client(mainFrame, connectionFrame);
	}
}
