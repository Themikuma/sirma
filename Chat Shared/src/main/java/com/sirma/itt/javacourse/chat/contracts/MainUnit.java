package com.sirma.itt.javacourse.chat.contracts;

import java.io.IOException;
import java.util.Locale;

/**
 * The interface that defines every main unit.
 * 
 * @author user
 */
public interface MainUnit {
	/**
	 * Starts the connection unit.
	 */
	void startConnectionUnit();

	/**
	 * Disconnects from or stops the server.
	 * 
	 * @throws IOException
	 *             if an IO exception occurs while trying to close the connection.
	 */
	void closeConnection() throws IOException;

	/**
	 * Called when the connection has been closed.
	 */
	void onConnectionClosed();

	/**
	 * Called when an error has occured, letting the implementation decide what to do with it.
	 * 
	 * @param error
	 *            the error
	 */
	void onError(String error);

	/**
	 * Get the supported locale from the array of supported locales.
	 * 
	 * @param index
	 *            the index of the locale
	 * @return the locale
	 */
	Locale getLocaleFromIndex(int index);

	/**
	 * Set the currently used locale to be used from the main unit and the connection unit.
	 * 
	 * @param locale
	 *            the locale
	 */
	void setCurrentLocale(Locale locale);

	/**
	 * Get the current locale that is being used by all components of the client object.
	 * 
	 * @return the locale
	 */
	Locale getCurrentLocale();

	/**
	 * Called when an user is added.
	 * 
	 * @param user
	 *            the nickname of the user
	 */
	void onUserAdded(String user);

	/**
	 * Called when an user is removed.
	 * 
	 * @param user
	 *            the nickname of the user
	 */
	void onUserRemoved(String user);

	/**
	 * Called when a message is added.
	 * 
	 * @param user
	 *            the user from which the message is sent
	 * @param message
	 *            the message to be displayed
	 */
	void onMessageAdded(String user, String message);

	/**
	 * Called once the main object has been created and all of it's components are set up correctly.
	 */
	void start();

}
