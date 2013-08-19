package com.sirma.itt.javacourse.chat.structures;

import java.awt.Color;

/**
 * A wrapper object representing a message.
 * 
 * @author user
 */
public final class Message {
	private final String message;
	private final String date;
	private final String sender;
	private final Color color;

	/**
	 * Setting up the message text, the date, and the sender.
	 * 
	 * @param message
	 *            the text of the message
	 * @param date
	 *            the date of the message
	 * @param sender
	 *            the sender of the message
	 */
	public Message(String message, String date, String sender) {
		this(message, date, sender, Color.DARK_GRAY);
	}

	/**
	 * An additional constructor giving the opportunity to set the color of the message.
	 * 
	 * @param message
	 *            the message
	 * @param date
	 *            the date of the message
	 * @param sender
	 *            the sender of the message
	 * @param color
	 *            the color of the message
	 */
	public Message(String message, String date, String sender, Color color) {
		this.message = message;
		this.date = date;
		this.sender = sender;
		this.color = color;
	}

	/**
	 * Getter method for message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Getter method for date.
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Getter method for sender.
	 * 
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Getter method for color.
	 * 
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

}
