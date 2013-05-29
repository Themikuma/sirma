package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * A multiply command that triggers the multiply method in the calculator object.
 * 
 * @author user
 */
public class MultiplyCommand implements Command {
	@Override
	public String execute(String input, Calculator calc) {
		return calc.multiply(input);
	}

}
