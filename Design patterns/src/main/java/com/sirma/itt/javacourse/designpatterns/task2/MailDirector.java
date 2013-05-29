package com.sirma.itt.javacourse.designpatterns.task2;

/**
 * The director, constructing an object using the builder interface.
 * 
 * @author user
 */
public class MailDirector {

	private MailBuilder mailBuilder;

	/**
	 * Constructor of the maildirector class, setting the mailBuilder field.
	 * 
	 * @param mailBuilder
	 *            the mailBuilder to be used.
	 */
	public MailDirector(MailBuilder mailBuilder) {
		this.mailBuilder = mailBuilder;
	}

	/**
	 * Constructing the mail using fluent interface.
	 * 
	 * @param from
	 *            the sender of the mail
	 * @param to
	 *            the receiver of the mail
	 * @param subject
	 *            the subject of the mail
	 * @param content
	 *            the content of the mail
	 * @param cc
	 *            the cc of the mail
	 * @param attachments
	 *            the attachments of the mail
	 */
	public void constructMail(String from, String to, String subject, String content, String cc,
			String... attachments) {
		mailBuilder.from(from).to(to).subject(subject).content(content).cc(cc)
				.attachments(attachments);
	}

	/**
	 * Getter method for mailBuilder.
	 * 
	 * @return the mailBuilder
	 */
	public MailBuilder getMailBuilder() {
		return mailBuilder;
	}

	/**
	 * Setter method for mailBuilder.
	 * 
	 * @param mailBuilder
	 *            the mailBuilder to set
	 */
	public void setMailBuilder(MailBuilder mailBuilder) {
		this.mailBuilder = mailBuilder;
	}
}
