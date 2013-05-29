package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * An add command that triggers the add method in the calculator object.
 * 
 * @author user
 */
public class AdditionCommand implements Command {

	@Override
	public String execute(String input, Calculator calc) {
		return calc.add(input);
	}

}
