package com.sirma.itt.javacourse.designpatterns.task2;

/**
 * An implementation of the Bloch's variant of the builder pattern. The {@link BlochMail} class is
 *  immutable therefore its state is consistant and doesnt change runtime.
 * @author metodskiPC
 *
 */
public class BlochMail {
	private final String from;
	private final String to;
	private final String subject;
	private final String content;
	private final String cc;
	private final String[] attachments;
	/**
	 * The constructor of the class. Takes in a builder as a parameter to construct itself.
	 * @param builder the builder used.
	 */
	private BlochMail(Builder builder){
		this.from = builder.from;
		this.to = builder.to;
		this.subject = builder.subject;
		this.content = builder.content;
		this.cc = builder.cc;
		this.attachments = builder.attachments;
	}
	/**
	 * The builder inner class. Constructs the {@link BlochMail} object.
	 * @author metodskiPC
	 *
	 */
	public static class Builder{
		private final String from;
		private String to="default";
		private String subject="default";
		private String content="default";
		private String cc="default";
		private String[] attachments = null;
		public Builder(String from){
			this.from = from;
		}
		public Builder to(String to){
			this.to=to;
			return this;
		}
		public Builder subject(String subject){
			this.subject = subject;
			return this;
		}
		public Builder content(String content){
			this.content = content;
			return this;
		}
		public Builder cc(String cc){
			this.cc = cc;
			return this;
		}
		public void attachments(String... attachments){
			this.attachments = attachments;
		}
		public BlochMail build(){
			return new BlochMail(this);
		}
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getCc() {
		return cc;
	}
	public String[] getAttachments() {
		return attachments;
	}
}
