package com.sirma.itt.javacourse.chat.contracts;

import java.util.Locale;

/**
 * The interface used by every main window, be it a server or client one.
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
	 */
	void disconnect();

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
	void addMessage(String user, String message);

	/**
	 * Called once the main object has been created and all of it's components are set up correctly.
	 */
	void start();

	/**
	 * Called when the server has been stopped or a disconnect has been forced.
	 */
	void onServerStopped();
}
