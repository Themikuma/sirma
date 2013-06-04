package com.sirma.itt.javacourse.inputoutput.task5;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
	public static DirectoryInfo listContent(String path) {
		Path actualPath = Paths.get(path);
		List<String> files = new ArrayList<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(actualPath)) {

			for (Path file : stream) {
				files.add(file.getFileName().toString());
			}
			return new DirectoryInfo(files, false, false);
		} catch (NoSuchFileException e) {
			return new DirectoryInfo(null, true, false);
		} catch (NotDirectoryException e) {
			return new DirectoryInfo(null, false, true);
		} catch (IOException e) {
			throw new RuntimeException("Something went wrong with the file", e);
		}

	}

	/**
	 * A Static nested class that contains information for the current file such as a list of the
	 * files in it, a boolean indicating if the file exists, and a boolean indicating if the path is
	 * a file or a directory.
	 * 
	 * @author user
	 */
	public static final class DirectoryInfo {
		private final List<String> files;
		private final boolean doesNotExist;
		private final boolean isFile;

		/**
		 * Constructing the class. Since the class is immutable, once it has been instantiated, it's
		 * state can't be changed.
		 * 
		 * @param files
		 *            a list of files in the current directory.
		 * @param doesNotExist
		 *            indicates if the file exists.
		 * @param isFile
		 *            indicates if the path is a file.
		 */
		public DirectoryInfo(List<String> files, boolean doesNotExist, boolean isFile) {
			super();
			this.files = files;
			this.doesNotExist = doesNotExist;
			this.isFile = isFile;
		}

		/**
		 * Getter method for files.
		 * 
		 * @return the files
		 */
		public List<String> getFiles() {
			return files;
		}

		/**
		 * Getter method for doesNotExist.
		 * 
		 * @return the doesNotExist
		 */
		public boolean doesNotExist() {
			return doesNotExist;
		}

		/**
		 * Getter method for isFile.
		 * 
		 * @return the isFile
		 */
		public boolean isFile() {
			return isFile;
		}

	}
}
