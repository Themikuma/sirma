package com.sirma.itt.javacourse.gui.task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The logic of the calculator, handles the pressing of the buttons and does the calculations.
 * 
 * @author user
 */
public class CommandListener implements ActionListener {
	private Calculator parent;
	private boolean isFirstDigit = true;
	private double result;
	private String command;
	private String lastCommand;
	private boolean begin = true;

	/**
	 * Setting up the parent window of the action listener.
	 * 
	 * @param parent
	 *            the parent window
	 */
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
					isFirstDigit = true;
					begin = false;
				} else {
					Double number;
					try {
						number = Double.parseDouble(parent.getScreenText());

					} catch (NumberFormatException e1) {
						number = 0.0;
					}
					calculate(lastCommand, number);
					if (Double.isInfinite(result) || Double.isNaN(result))
						parent.setScreenText("Cannot divide by zero");
					else if (result == (int) result) {
						parent.setScreenText(Integer.toString((int) result));
					} else
						parent.setScreenText(Double.toString(result));
					isFirstDigit = true;
					lastCommand = command;
				}
			}

		}

	}

	/**
	 * Calculate the new result by doing the specified operation on the result with a new number.
	 * 
	 * @param command
	 *            the specified command
	 * @param number
	 *            the new number
	 */
	public void calculate(String command, double number) {

		if ("+".equals(command)) {
			result += number;
		} else if ("-".equals(command)) {
			result -= number;
		} else if ("/".equals(command)) {
			result /= number;
		} else if ("*".equals(command)) {
			result *= number;
		} else if ("=".equals(command)) {
			result = number;
		}

	}

	/**
	 * Delete the last char from the input string.
	 * 
	 * @param input
	 *            the input string to delete from
	 * @return the input string with the deleted last char
	 */
	public String deleteLastDigit(String input) {
		if (input.length() == 1) {
			isFirstDigit = true;
			return "0";
		} else
			return input.substring(0, input.length() - 1);
	}

	/**
	 * Turn an input string into an input string that is valid for a double parse.
	 * 
	 * @param input
	 *            the input string
	 * @return the input string with an appended dot in the end
	 */
	public String turnDouble(String input) {
		if (input.contains("."))
			return input;
		else
			return input + ".";
	}

	/**
	 * Getter method for result.
	 * 
	 * @return the result
	 */
	public double getResult() {
		return result;
	}

	/**
	 * Setter method for result.
	 * 
	 * @param result
	 *            the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}
}
