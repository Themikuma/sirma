package com.sirma.itt.javacourse.chat.contracts;

import java.util.Locale;

public interface ConnectionUnit {

	/**
	 * Called when the main unit implementation decides. Starts the connection unit implementation.
	 */
	void start();

	/**
	 * Called when a succesfull connection is established.
	 */
	void connectionEstablished();

	/**
	 * Called when a connection is not established for some reason.
	 * 
	 * @param error
	 *            the error that occurred during the connection
	 */
	void connectionRefused(String error);

	/**
	 * Get the currently used locale from the main client class.
	 * 
	 * @return the locale
	 */
	Locale getCurrentLocale();

	/**
	 * Setter method for client.
	 * 
	 * @param client
	 *            the client to set
	 */

}
