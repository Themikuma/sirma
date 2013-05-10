package com.sirma.itt.javacourse.inputoutput.task2;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
public class ConsoleToFileWriterAutomatic implements ConsoleToFileWriter {
	private ByteArrayInputStream input;

	/**
	 * Constructor of the class. Takes in a string and turns it into a ByteArrayInputStream.
	 * 
	 * @param inputString
	 *            the input String to be turned into an input stream
	 */
	public ConsoleToFileWriterAutomatic(String inputString) {
		input = new ByteArrayInputStream(inputString.getBytes());
	}

	@Override
	public void writeToFile() {
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

	/**
	 * Getter method for input.
	 * 
	 * @return the input
	 */
	public ByteArrayInputStream getInput() {
		return input;
	}

	/**
	 * Setter method for input.
	 * 
	 * @param input
	 *            the input to set
	 */
	public void setInput(ByteArrayInputStream input) {
		this.input = input;
	}

}
