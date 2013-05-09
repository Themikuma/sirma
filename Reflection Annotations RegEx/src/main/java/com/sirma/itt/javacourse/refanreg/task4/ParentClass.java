package com.sirma.itt.javacourse.refanreg.task4;

/**
 * A parent class with an overridden compareTo method, to support sorting of the array of child
 * classes from their annotations.
 * 
 * @author user
 */
public class ParentClass implements Comparable<ParentClass> {

	@Override
	public int compareTo(ParentClass o) {
		return this.getClass().getAnnotation(Numbered.class).id()
				- ((ParentClass) o).getClass().getAnnotation(Numbered.class).id();
	}

}
