package com.sirma.itt.javacourse.inputoutput.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleToFileWriter {

	public static void writeToFile() {
		FileWriter file = null;
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();

		try {
			file = new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter outputStream = new BufferedWriter(file);
		while (in.hasNextLine()) {
			try {
				String line = in.nextLine();
				if (".".equals(line)) {
					outputStream.close();
					break;
				}
				outputStream.write(line);
				outputStream.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		writeToFile();
	}
}
