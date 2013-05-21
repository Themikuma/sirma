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

		try (FileOutputStream fileOutput = new FileOutputStream(path);
				ObjectOutputStream output = new ObjectOutputStream(fileOutput)) {
			output.writeObject(o);

		} catch (IOException e) {
			throw new RuntimeException("General I/O exception", e);
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

		try (FileInputStream fileInput = new FileInputStream(path);
				ObjectInputStream input = new ObjectInputStream(fileInput)) {
			return (UserDefinedObject) input.readObject();

		} catch (FileNotFoundException e) {
			throw new RuntimeException("The file can't be found", e);
		} catch (IOException e) {
			throw new RuntimeException("General I/O exception", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("The class UserDefinedObject cannot be found", e);
		}

	}
}
