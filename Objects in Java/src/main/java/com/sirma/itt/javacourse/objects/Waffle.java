package com.sirma.itt.javacourse.objects;

/**
 * A waffle product implementing the sweet interface.
 * 
 * @author user
 */
public class Waffle extends Product implements Sweet {

	@Override
	public boolean isTooSweet() {
		// TODO Auto-generated method stub
		return true;
	}

}