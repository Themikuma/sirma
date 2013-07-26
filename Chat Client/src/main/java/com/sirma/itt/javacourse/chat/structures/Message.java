package com.sirma.itt.javacourse.chat.structures;


/**
 * A wrapper object representing a message.
 * 
 * @author user
 */
public class Message {
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
		super();
		this.message = message;
		this.date = date;
		this.sender = sender;
	}

	private String message;
	private String date;
	private String sender;

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

}
