package com.sirma.itt.javacourse.inputoutput.task2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The Manual reader/writer class that requires user input.
 * 
 * @author user
 */
public class ConsoleToFileWriterManual implements ConsoleToFileWriter {

	@Override
	public void writeToFile() {
		Path file = null;
		Scanner in = new Scanner(System.in);
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
