package com.sirma.itt.javacourse.inputoutput.task6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataClass {

	public DataClass() {
		// TODO Auto-generated constructor stub
	}

	public void saveObject(String path, UserDefinedObject o) {
		FileOutputStream fileOutput = null;
		try {
			fileOutput = new FileOutputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (ObjectOutputStream output = new ObjectOutputStream(fileOutput)) {
			output.writeObject(o);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserDefinedObject getObject(String path) {
		FileInputStream fileInput = null;
		UserDefinedObject read = null;
		try {
			fileInput = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (ObjectInputStream input = new ObjectInputStream(fileInput)) {
			read = (UserDefinedObject) input.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return read;
	}
}
