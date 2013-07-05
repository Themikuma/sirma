package com.sirma.itt.javacourse.designpatterns.task2;

/**
 * An implementation of the Bloch's variant of the builder pattern. The {@link BlochMail} class is
 * immutable therefore its state is consistant and doesnt change runtime.
 * 
 * @author metodskiPC
 */
public final class BlochMail {
	private final String from;
	private final String to;
	private final String subject;
	private final String content;
	private final String cc;
	private final String[] attachments;

	/**
	 * The constructor of the class. Takes in a builder as a parameter to construct itself.
	 * 
	 * @param builder
	 *            the builder used.
	 */
	private BlochMail(Builder builder) {
		this.from = builder.from;
		this.to = builder.to;
		this.subject = builder.subject;
		this.content = builder.content;
		this.cc = builder.cc;
		this.attachments = builder.attachments;
	}

	/**
	 * Getter method for from.
	 * 
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Getter method for to.
	 * 
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Getter method for subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Getter method for content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Getter method for cc.
	 * 
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * Getter method for attachments.
	 * 
	 * @return the attachments
	 */
	public String[] getAttachments() {
		return attachments;
	}

	/**
	 * The builder inner class. Constructs the {@link BlochMail} object.
	 * 
	 * @author metodskiPC
	 */
	public static class Builder {
		private final String from;
		private String to = "default";
		private String subject = "default";
		private String content = "default";
		private String cc = "default";
		private String[] attachments = null;

		/**
		 * Set the from field. It is placed in the constructor because it's the only necessary
		 * field.
		 * 
		 * @param from
		 *            value of the from field
		 */
		public Builder(String from) {
			this.from = from;
		}

		/**
		 * Set the to field.
		 * 
		 * @param to
		 *            value of the to field
		 * @return this object so we can chain the methods
		 */
		public Builder to(String to) {
			this.to = to;
			return this;
		}

		/**
		 * Set the subject field.
		 * 
		 * @param subject
		 *            value of the subject field
		 * @return this object so we can chain the methods
		 */
		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		/**
		 * Set the content field.
		 * 
		 * @param content
		 *            value of the content field
		 * @return this object so we can chain the methods
		 */
		public Builder content(String content) {
			this.content = content;
			return this;
		}

		/**
		 * Set the cc field.
		 * 
		 * @param cc
		 *            value of the cc field
		 * @return this object so we can chain the methods
		 */
		public Builder cc(String cc) {
			this.cc = cc;
			return this;
		}

		/**
		 * Set the attachments field. This method is void indicating that we cannot chain methods
		 * any further.
		 * 
		 * @param attachments
		 *            an array of values-attachments
		 */
		public void attachments(String... attachments) {
			this.attachments = attachments;
		}

		/**
		 * build the {@link BlochMail} object from the set fields so far.
		 * 
		 * @return the {@link BlochMail} object
		 */
		public BlochMail build() {
			return new BlochMail(this);
		}
	}

}
