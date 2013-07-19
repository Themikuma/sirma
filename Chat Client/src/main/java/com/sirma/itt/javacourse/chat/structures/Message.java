package com.sirma.itt.javacourse.chat.structures;

import java.util.Date;

public class Message {
	/**
	 * @param message
	 * @param date
	 * @param sender
	 */
	public Message(String message, Date date, String sender) {
		super();
		this.message = message;
		this.date = date;
		this.sender = sender;
	}

	private String message;
	private Date date;
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
	 * Setter method for message.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Getter method for date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter method for date.
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * Setter method for sender.
	 * 
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
}
