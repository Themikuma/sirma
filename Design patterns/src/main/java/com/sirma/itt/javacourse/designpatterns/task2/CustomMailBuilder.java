package com.sirma.itt.javacourse.designpatterns.task2;

/**
 * A concrete implementation of the {@link MailBuilder} interface for constructing a {@link Mail}.
 * 
 * @author user
 */
public class CustomMailBuilder extends MailBuilder {

	/**
	 * Setting up the mail object.
	 * 
	 * @param mail
	 *            the mail object to be used
	 */
	public CustomMailBuilder(Mail mail) {
		this.setEmail(mail);
	}

	@Override
	public MailBuilder from(String mail) {
		this.getEmail().setFrom(mail);
		return this;

	}

	@Override
	public MailBuilder to(String mail) {
		this.getEmail().setTo(mail);
		return this;

	}

	@Override
	public MailBuilder subject(String subj) {
		this.getEmail().setSubject(subj);
		return this;

	}

	@Override
	public MailBuilder content(String cont) {
		this.getEmail().setContent(cont);
		return this;

	}

	@Override
	public MailBuilder cc(String cc) {
		this.getEmail().setCc(cc);
		return this;

	}

	@Override
	public void attachments(String... attach) {
		this.getEmail().setAttachments(attach);

	}
}
