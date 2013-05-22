package com.sirma.itt.javacourse.inputoutput.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class, containing a method for reading a file and a method for reversing the file.
 * 
 * @author user
 */
public class FileReverser {

	/**
	 * Reads the file from the specified path. the name of the file to be opened * @param filePath
	 * 
	 * @param filePath
	 *            the path of the file to be read
	 * @return a StringBuilder containing all lines of the file.
	 */

	public StringBuilder readFile(String filePath) {
		StringBuilder fileContent = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (fileContent.length() == 0) {
					fileContent.append(line);
				} else
					fileContent.append("\n" + line);
			}

		} catch (IOException e) {
			throw new RuntimeException("General I/O exception", e);
		}
		return fileContent;
	}

	/**
	 * Reverses the file using the reverse() method of the StringBuffer class and writes the
	 * reversed data via Files.write(). the name of the file to be reversed
	 * 
	 * @param filePath
	 *            the path of the file to be reversed
	 */
	public void reverseFile(String filePath) {

		try {
			Files.write(Paths.get(filePath), readFile(filePath).reverse().toString().getBytes());
		} catch (IOException e) {
			throw new RuntimeException("General I/O exception", e);
		}
	}

}
