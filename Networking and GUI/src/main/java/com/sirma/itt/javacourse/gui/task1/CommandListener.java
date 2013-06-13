package com.sirma.itt.javacourse.gui.task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandListener implements ActionListener {
	private Calculator parent;
	private boolean isFirstDigit = true;
	private double result;
	private String command;
	private String lastCommand;
	private boolean begin = true;

	public CommandListener(Calculator parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();

		try {
			Double.parseDouble(command);
			if (isFirstDigit) {
				parent.setScreenText(command);
				isFirstDigit = false;
			} else
				parent.setScreenText(parent.getScreenText() + command);
		} catch (NumberFormatException exception) {
			if ("C".equals(command)) {
				parent.setScreenText("0");
			}
			if ("«".equals(command)) {
				parent.setScreenText(deleteLastDigit(parent.getScreenText()));
			} else if (".".equals(command)) {
				parent.setScreenText(turnDouble(parent.getScreenText()));
				isFirstDigit = false;
			} else {
				if (begin) {
					lastCommand = command;
					result = Double.parseDouble(parent.getScreenText());
					System.out.println(result);
					isFirstDigit = true;
					begin = false;
				} else {
					calculate(Double.parseDouble(parent.getScreenText()));
					if (result == (int) result) {
						parent.setScreenText(Integer.toString((int) result));
					} else
						parent.setScreenText(Double.toString(result));
					isFirstDigit = true;
					lastCommand = command;
				}
			}

		}

	}

	public void calculate(double number) {

		if ("+".equals(lastCommand)) {
			result += number;
		} else if ("-".equals(lastCommand)) {
			result -= number;
		} else if ("/".equals(lastCommand)) {
			result /= number;
		} else if ("*".equals(lastCommand)) {
			result *= number;
		} else if ("=".equals(lastCommand)) {
			result = number;
		}

	}

	public String deleteLastDigit(String input) {
		if (input.length() == 1) {
			isFirstDigit = true;
			return "0";
		} else
			return input.substring(0, input.length() - 1);
	}

	public String turnDouble(String input) {
		if (input.contains("."))
			return input;
		else
			return input + ".";
	}
}
