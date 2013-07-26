package com.sirma.itt.javacourse.chat.client.maincomponents;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * The document that is going to limit the text field's input to a specified char count.
 * 
 * @author user
 */
public class MaxCharsDocument extends PlainDocument {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1622304856769517712L;
	private int maxChars;

	/**
	 * Sets the maximum chars.
	 * 
	 * @param maxChars
	 *            the maximum chars
	 */
	public MaxCharsDocument(int maxChars) {
		super();
		this.maxChars = maxChars;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if ((getLength() + str.length()) < maxChars)
			super.insertString(offs, str, a);
	}

}
