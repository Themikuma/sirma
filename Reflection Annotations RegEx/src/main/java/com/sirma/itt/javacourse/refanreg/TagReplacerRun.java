package com.sirma.itt.javacourse.refanreg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TagReplacerRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TagReplacer replacer = new TagReplacer();
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String result = "";
		String line = null;
		try {
			while (!(line = br.readLine()).equals("")) {
				result += line + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(replacer.replaceTags(result));

	}

}
