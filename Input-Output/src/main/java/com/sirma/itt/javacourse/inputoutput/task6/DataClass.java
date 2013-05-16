package com.sirma.itt.javacourse.inputoutput.task6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * A class with two methods for saving and reading an object.
 * 
 * @author user
 */
public class DataClass {

	/**
	 * Saves a custom object to a file using serialization.
	 * 
	 * @param path
	 *            the path to the file that is going to be saved
	 * @param o
	 *            the object that is going to be saved
	 */
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

	/**
	 * Reads an object from the specified path.
	 * 
	 * @param path
	 *            the path from which the object is going to be read
	 * @return the read object
	 */
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
