package com.sirma.itt.javacourse.refanreg;

public class TagReplacer {

	public String replaceTags(String input) {
		String result = input.replaceAll("<x[^<]*[^>]/x>", "<x/>");
		return result;
	}

}
