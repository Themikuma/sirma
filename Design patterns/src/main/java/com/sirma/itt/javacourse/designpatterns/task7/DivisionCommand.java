package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * A division command that triggers the division method in the calculator object.
 * 
 * @author user
 */
public class DivisionCommand implements Command {
	@Override
	public String execute(String input, Calculator calc) {
		return calc.divide(input);
	}

}
