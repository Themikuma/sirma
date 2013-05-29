package com.sirma.itt.javacourse.designpatterns.task7;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory with a hashmap containing all the commands.
 * 
 * @author user
 */
public class CommandFactory {
	private Map<String, Command> commandMap = new HashMap<String, Command>();

	/**
	 * Constructor of the class, adding the already created commands to the hashmap.
	 */
	public CommandFactory() {
		commandMap.put("+", new AdditionCommand());
		commandMap.put("-", new SubstractionCommand());
		commandMap.put("/", new DivisionCommand());
		commandMap.put("*", new MultiplyCommand());
		commandMap.put("^", new PowerCommand());
	}

	/**
	 * Adding a new command to the hashmap.
	 * 
	 * @param operation
	 *            the operation key for example +
	 * @param cmd
	 *            the command object
	 */
	public void addCommand(String operation, Command cmd) {
		commandMap.put(operation, cmd);
	}

	/**
	 * The factory method of the class comparing each key of the hashmap with the input string and
	 * returning the appropriate command.
	 * 
	 * @param input
	 *            the input string
	 * @return the appropriate command
	 */
	public Command getCommand(String input) {
		for (String operation : commandMap.keySet()) {
			if (input.contains(operation))
				return commandMap.get(operation);
		}
		return null;
	}

	/**
	 * Getter method for commandMap.
	 * 
	 * @return the commandMap
	 */
	public Map<String, Command> getCommandMap() {
		return commandMap;
	}

	/**
	 * Setter method for commandMap.
	 * 
	 * @param commandMap
	 *            the commandMap to set
	 */
	public void setCommandMap(Map<String, Command> commandMap) {
		this.commandMap = commandMap;
	}

}
