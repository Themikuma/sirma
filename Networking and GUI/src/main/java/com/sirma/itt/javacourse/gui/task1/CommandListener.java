package com.sirma.itt.javacourse.gui.task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandListener implements ActionListener {
	private Calculator parent;
	private boolean isFirstDigit = true;
	private double result;

	public CommandListener(Calculator parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		// TODO mahai povtoreniq
		try {
			int number = Integer.parseInt(command);
			if (isFirstDigit) {
				parent.setScreenText(command);
				isFirstDigit = false;
			} else
				parent.setScreenText(parent.getScreenText() + command);
		} catch (NumberFormatException exception) {
			if ("+".equals(command)) {

				result += Integer.parseInt(parent.getScreenText());

			} else if ("-".equals(command)) {
				result -= Integer.parseInt(parent.getScreenText());

			} else if ("/".equals(command)) {
				result /= Integer.parseInt(parent.getScreenText());

			} else if ("*".equals(command)) {
				result *= Integer.parseInt(parent.getScreenText());

			} else if ("=".equals(command)) {
				result += Integer.parseInt(parent.getScreenText());

			}
			parent.setScreenText(Double.toString(result));
			isFirstDigit = true;

		}

	}
}
