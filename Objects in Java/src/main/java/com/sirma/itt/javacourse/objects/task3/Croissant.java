package com.sirma.itt.javacourse.objects.task3;

/**
 * A croissant product implementing the sweet interface.
 * 
 * @author user
 */
public class Croissant extends Product implements Sweet {

	@Override
	public boolean isTooSweet() {
		return false;
	}

}
