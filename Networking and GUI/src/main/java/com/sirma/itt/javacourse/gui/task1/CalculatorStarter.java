package com.sirma.itt.javacourse.gui.task1;

import javax.swing.SwingUtilities;

/**
 * Basic use of the calculator.
 * 
 * @author user
 */
public final class CalculatorStarter {

	/**
	 * 
	 */
	private CalculatorStarter() {

	}

	/**
	 * Starting the UI of the calculator.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		final Calculator calc = new Calculator();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				calc.initUI(400, 400);

			}
		});

	}
}
