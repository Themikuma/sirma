package com.sirma.itt.javacourse.refanreg;

public class ParentClass implements Comparable<ParentClass> {

	@Override
	public int compareTo(ParentClass o) {
		return this.getClass().getAnnotation(Numbered.class).id()
				- ((ParentClass) o).getClass().getAnnotation(Numbered.class).id();
	}

}
