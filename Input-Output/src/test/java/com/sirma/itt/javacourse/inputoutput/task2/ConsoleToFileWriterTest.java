package com.sirma.itt.javacourse.inputoutput.task2;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
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
		String inputString = "hello.txt\nasd\nqweqwe\n.\n";
		String expectedResult = "asd\nqweqwe\n";
		ConsoleToFileWriter writer = new ConsoleToFileWriterAutomatic(inputString);
		writer.writeToFile();

		Path file = Paths.get("hello.txt");
		Charset charset = Charset.forName("UTF-8");
		String resultString = "";
		List<String> lines;
		try {
			lines = Files.readAllLines(file, charset);
			for (String line : lines) {
				resultString += line + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(expectedResult, resultString);
	}
}
