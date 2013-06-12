package com.sirma.itt.javacourse.inputoutput.task2;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

/**
 * Testing the automatic version of the ConsoleToFileWriter class.
 * 
 * @author user
 */
public class ConsoleToFileWriterTest {

	/**
	 * Testing the writeToFile method by passing it a string instead of using user input.
	 */
	@Test
	public void testWriteToFile() {
		String inputString = "line1\nline2\nline3\n.\n";
		String expectedResult = "line1\nline2\nline3\n";
		ConsoleToFileWriter writer = new ConsoleToFileWriter();
		InputStream input = new ByteArrayInputStream(inputString.getBytes());
		writer.writeToFile("resources\\hello.txt", input);

		Path file = Paths.get("resources\\hello.txt");
		Charset charset = Charset.forName("UTF-8");
		String resultString = "";
		List<String> lines;
		try {
			lines = Files.readAllLines(file, charset);
			for (String line : lines) {
				resultString += line + "\n";
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assertEquals(expectedResult, resultString);
	}
}
