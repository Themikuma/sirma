package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * The invoker that asks the command to carry out the request.
 * 
 * @author user
 */
public class CommandInvoker {
	private CommandFactory cmdFactory;

	/**
	 * Setting the commandFactory to be used with the invoker.
	 * 
	 * @param cmdFactory
	 *            the command factory
	 */
	public CommandInvoker(CommandFactory cmdFactory) {
		this.cmdFactory = cmdFactory;
	}

	/**
	 * Getting the appropriate command from the command factory and executing it.
	 * 
	 * @param input
	 *            the input string
	 * @param calc
	 *            the calculator on which the command is going to be executed
	 * @return the result of the executed command
	 */

	public String execute(String input, Calculator calc) {
		return cmdFactory.getCommand(input).execute(input, calc);
	}

	/**
	 * Getter method for cmdFactory.
	 * 
	 * @return the cmdFactory
	 */
	public CommandFactory getCmdFactory() {
		return cmdFactory;
	}

	/**
	 * Setter method for cmdFactory.
	 * 
	 * @param cmdFactory
	 *            the cmdFactory to set
	 */
	public void setCmdFactory(CommandFactory cmdFactory) {
		this.cmdFactory = cmdFactory;
	}

}
