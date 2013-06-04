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
	 * @param input
	 *            the {@link InputStream} containing the data to be written to the file
	 */
	// TODO FIX THE SCANNER ! File name in the method signature !
	public void writeToFile(InputStream input) {
		Path file = null;
		Scanner in = new Scanner(input);
		String fileName = in.nextLine();
		file = Paths.get(fileName);
		Charset charset = Charset.forName("UTF-8");

		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (".".equals(line))
					break;

				writer.append(line);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();

	}

}
