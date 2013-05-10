package com.sirma.itt.javacourse.inputoutput.task5;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
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
	 * Lists all the directories and files in a directory via a directorystream.
	 * 
	 * @param path
	 *            the path of the directory/file
	 * @return directory, if the path is a folder/ file, if the path is a file/ file not found if
	 *         the path directory doesnt exist
	 * @throws NoSuchFileException
	 *             throws an exception if the file doesnt exist.
	 */
	public static String listContent(String path) throws NoSuchFileException {
		Path actualPath = Paths.get(path);
		String directories = "";
		String files = "";
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(actualPath)) {

			for (Path file : stream) {
				if (Files.isDirectory(file, LinkOption.NOFOLLOW_LINKS)) {
					directories += file.getFileName() + ",";
				} else
					files += file.getFileName() + ",";
			}
			System.out.println("The directory containst the following directories: " + directories
					+ " and the following files: " + files);
			return "directory";
		} catch (NoSuchFileException e) {
			throw new NoSuchFileException("The file does not exist");
		} catch (NotDirectoryException e) {
			System.out.println("That's a file.");
			return "file";
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		return null;

	}
}
