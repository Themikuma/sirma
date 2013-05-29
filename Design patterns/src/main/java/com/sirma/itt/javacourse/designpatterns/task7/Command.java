package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * The common interface of all commands.
 * 
 * @author user
 */
public interface Command {
	/**
	 * Executes the command by passing the input to the calculator object.
	 * 
	 * @param input
	 *            the input calculation
	 * @param calc
	 *            the calculator object on which the command will be executed
	 * @return the result
	 */
	String execute(String input, Calculator calc);
}
