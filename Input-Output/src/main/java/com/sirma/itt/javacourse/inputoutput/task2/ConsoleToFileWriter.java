package com.sirma.itt.javacourse.inputoutput.task2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The automatic reader/writer class that requires an input stream. Used for testing purposes.
 * 
 * @author user
 */
public class ConsoleToFileWriter {

	/**
	 * Gets data from the input {@link InputStream} and writes it to a file. Can be used with
	 * System.in for console input or with any other {@link InputStream}.
	 * 
	 * @param fileName
	 *            the name of the file to be saved to
	 * @param input
	 *            the {@link InputStream} containing the data to be written to the file
	 */

	public void writeToFile(String fileName, InputStream input) {
		Path file = null;
		file = Paths.get(fileName);
		Charset charset = Charset.forName("UTF-8");

		try (BufferedWriter writer = Files.newBufferedWriter(file, charset);
				Scanner in = new Scanner(input)) {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (".".equals(line))
					break;

				writer.append(line);
				writer.newLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("A General I/O exception occured", e);
		}

	}

}
