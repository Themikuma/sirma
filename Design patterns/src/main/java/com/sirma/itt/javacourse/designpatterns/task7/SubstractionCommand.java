package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * A substraction command that triggers the substraction method in the calculator object.
 * 
 * @author user
 */
public class SubstractionCommand implements Command {
	@Override
	public String execute(String input, Calculator calc) {
		return calc.substract(input);
	}
}
