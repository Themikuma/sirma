package com.sirma.itt.javacourse.refanreg;

import java.util.Arrays;

public class SortNumberedClasses {
	public static void main(String[] args) {
		ParentClass[] classArray = { new ChildClassThree(), new ChildClassOne(),
				new ChildClassTwo() };
		Arrays.sort(classArray);
		for (ParentClass parent : classArray) {
			System.out.println(parent);
		}
	}
}
