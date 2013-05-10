package com.sirma.itt.javacourse.inputoutput.task4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class with methods, transferring the data of an inputstream to outputstream.
 * 
 * @author user
 */
public class TransferObject {
	private InputStream input;
	private OutputStream output;

	/**
	 * The constructor taking in an instance of an inputstream and an instance of an outputstream.
	 * 
	 * @param input
	 *            the instance of the input stream
	 * @param output
	 *            the instance of the output stream
	 */
	public TransferObject(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * Transfers the content of the inputstream to the outputstream and returns the bytes
	 * transferred.
	 * 
	 * @param numberOfBytes
	 *            the number of bytes to be transferred
	 * @param offset
	 *            the offset at which the transfer starts
	 * @return the number of bytes successfully transferred
	 */
	public int transfer(int numberOfBytes, int offset) {

		byte[] inputBuffer = new byte[numberOfBytes];
		int size = 0;
		try {
			input.skip(offset);
			size = input.read(inputBuffer, 0, numberOfBytes);
			output.write(inputBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (size == -1) ? 0 : size;
	}

	/**
	 * Getter method for input.
	 * 
	 * @return the input
	 */
	public InputStream getInput() {
		return input;
	}

	/**
	 * Setter method for input.
	 * 
	 * @param input
	 *            the input to set
	 */
	public void setInput(InputStream input) {
		this.input = input;
	}

	/**
	 * Getter method for output.
	 * 
	 * @return the output
	 */
	public OutputStream getOutput() {
		return output;
	}

	/**
	 * Setter method for output.
	 * 
	 * @param output
	 *            the output to set
	 */
	public void setOutput(OutputStream output) {
		this.output = output;
	}

}
