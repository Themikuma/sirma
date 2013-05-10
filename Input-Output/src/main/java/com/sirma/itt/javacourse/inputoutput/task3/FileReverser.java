package com.sirma.itt.javacourse.inputoutput.task3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class, containing a method for reading a file and a method for reversing the file.
 * 
 * @author user
 */
public class FileReverser {
	private Path file;

	/**
	 * Construcotr of the class. Constructs the path field out of the given filePath string.
	 * 
	 * @param filePath
	 *            the path of the file to be opened
	 */
	public FileReverser(String filePath) {
		this.file = Paths.get(filePath);
	}

	/**
	 * Reads the file from the specified path. the name of the file to be opened
	 * 
	 * @return a StringBuffer containing all lines of the file.
	 */

	public StringBuffer readFile() {
		Charset charset = Charset.forName("UTF-8");
		StringBuffer fileContent = new StringBuffer();
		boolean first = true;
		try {
			List<String> lines = Files.readAllLines(file, charset);
			for (String line : lines) {
				if (first) {
					fileContent.append(line);
					first = false;
				} else
					fileContent.append("\n" + line);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContent;
	}

	/**
	 * Reverses the file using the reverse() method of the StringBuffer class and writes the
	 * reversed data via Files.write(). the name of the file to be reversed
	 */
	public void reverseFile() {

		try {
			Files.write(file, readFile().reverse().toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Getter method for file.
	 * 
	 * @return the file
	 */
	public Path getFile() {
		return file;
	}

	/**
	 * Setter method for file.
	 * 
	 * @param file
	 *            the file to set
	 */
	public void setFile(Path file) {
		this.file = file;
	}

}
