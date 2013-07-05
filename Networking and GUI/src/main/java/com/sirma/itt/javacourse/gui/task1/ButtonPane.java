package com.sirma.itt.javacourse.gui.task1;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A JPanel with a grid layout where the button are positioned.
 * 
 * @author user
 */
public class ButtonPane extends JPanel {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 8223569726456663886L;
	private final String[] buttonNames = new String[] { "7", "8", "9", "/", "4", "5", "6", "*",
			"1", "2", "3", "-", "0", ".", "+", "=", "«", "C" };

	/**
	 * Setting up each button and adding action listeners.
	 * 
	 * @param action
	 *            the actionlistener to be used for the buttons
	 */
	public ButtonPane(ActionListener action) {
		setLayout(new GridLayout(5, 4, 15, 15));
		ActionListener listener = action;
		for (String buttonName : buttonNames) {
			JButton button = new JButton(buttonName);
			button.addActionListener(listener);
			add(button);
		}
	}
}
