package com.sirma.itt.javacourse.gui.task1;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPane extends JPanel {
	private final String[] buttonNames = new String[] { "7", "8", "9", "/", "4", "5", "6", "*",
			"1", "2", "3", "-", "0", ".", "+", "=", "«", "C" };

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
