package com.sirma.itt.javacourse.objects.task3;

/**
 * A pretzel product implementing the salty interface.
 * 
 * @author user
 */
public class Pretzel extends Product implements Salty {

	@Override
	public boolean isTooSalty() {
		return false;
	}

}
