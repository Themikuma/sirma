package com.sirma.itt.javacourse.designpatterns.task2;

/**
 * The interface of the {@link Mail} creation.
 * 
 * @author user
 */
public abstract class MailBuilder {

	private Mail email;

	/**
	 * Sets the from field.
	 * 
	 * @param mail
	 *            the sender of the mail
	 * @return the current object, so we can chain methods
	 */
	public abstract MailBuilder from(String mail);

	/**
	 * Sets the to field.
	 * 
	 * @param mail
	 *            the receiver of the mail
	 * @return the current object, so we can chain methods
	 */
	public abstract MailBuilder to(String mail);

	/**
	 * Sets the subject field.
	 * 
	 * @param subj
	 *            the subject to be set
	 * @return the current object, so we can chain methods
	 */
	public abstract MailBuilder subject(String subj);

	/**
	 * Sets the content field.
	 * 
	 * @param cont
	 *            the content to be set
	 * @return the current object, so we can chain methods
	 */
	public abstract MailBuilder content(String cont);

	/**
	 * Sets the cc field.
	 * 
	 * @param cc
	 *            the cc to be set
	 * @return the current object, so we can chain methods
	 */
	public abstract MailBuilder cc(String cc);

	/**
	 * Sets the attachments field with a variable number of arguments. This method doesn't return
	 * anything since it's going to represent the end of the method chaining.
	 * 
	 * @param attach
	 *            the attachments to be set
	 */
	public abstract void attachments(String... attach);

	/**
	 * Getter method for email.
	 * 
	 * @return the email
	 */
	public Mail getEmail() {
		return email;
	}

	/**
	 * Setter method for email.
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(Mail email) {
		this.email = email;
	}

}
