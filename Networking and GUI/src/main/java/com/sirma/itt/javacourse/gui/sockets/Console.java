package com.sirma.itt.javacourse.gui.sockets;

import javax.swing.JTextArea;

/**
 * A custom {@link JTextArea} that could implement some additional methods for adding and getting
 * lines.
 * 
 * @author user
 */
public class Console extends JTextArea {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -3750447243388960162L;

	/**
	 * Append a line to the text area.
	 * 
	 * @param line
	 *            the line to append.
	 */
	public void appendLine(String line) {
		// append(line + "\n");
		setText(getText() + line + "\n");
	}

}
