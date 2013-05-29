package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * A power command that triggers the pow method in the calculator object.
 * 
 * @author user
 */
public class PowerCommand implements Command {
	@Override
	public String execute(String input, Calculator calc) {
		return calc.pow(input);
	}

}
