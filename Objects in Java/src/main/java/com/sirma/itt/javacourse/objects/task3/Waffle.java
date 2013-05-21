package com.sirma.itt.javacourse.objects.task3;

/**
 * A waffle product implementing the sweet interface.
 * 
 * @author user
 */
public class Waffle extends Product implements Sweet {

	@Override
	public boolean isTooSweet() {

		return true;
	}

}
