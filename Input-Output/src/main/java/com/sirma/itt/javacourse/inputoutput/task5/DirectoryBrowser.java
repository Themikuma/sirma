package com.sirma.itt.javacourse.inputoutput.task5;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Prints the content of a directory or the name of a file.
 * 
 * @author user
 */
public final class DirectoryBrowser {

	/**
	 * A private constructor, overriding the default one, so the class can't be initialized.
	 */
	private DirectoryBrowser() {

	}

	/**
	 * Lists all the directories and files in a directory via a {@link DirectoryStream}.
	 * 
	 * @param path
	 *            the path of the directory/file
	 * @return directory, if the path is a folder, file, if the path is a file, file not found if
	 *         the path directory doesn't exist
	 */
	public static String listContent(String path) {
		Path actualPath = Paths.get(path);
		String directories = "";
		String files = "";
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(actualPath)) {

			for (Path file : stream) {
				if (Files.isDirectory(file)) {
					directories += file.getFileName() + ",";
				} else
					files += file.getFileName() + ",";
			}
			return "The directory containst the following directories: " + directories
					+ " and the following files: " + files;
		} catch (NoSuchFileException e) {
			return "The file does not exist";
		} catch (NotDirectoryException e) {
			return "That's a file";
		} catch (IOException e) {
			throw new RuntimeException("Something went wrong with the file", e);
		}

	}
}
