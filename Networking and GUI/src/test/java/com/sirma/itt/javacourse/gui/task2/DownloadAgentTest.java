package com.sirma.itt.javacourse.gui.task2;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testing the {@link DownloadAgent} class.
 * 
 * @author user
 */
public class DownloadAgentTest {

	private static Downloader downloader;

	/**
	 * Set up the file that we are going to work on before the tests.
	 */
	@BeforeClass
	public static void setUp() {
		downloader = new Downloader("file:resources/Awesome.png", "resources//Awesome_2.png");
	}

	/**
	 * Test the downloaded's file bytes.
	 */
	@Test
	public void testDownloadFile() {
		BigInteger bytesRead = downloader.downloadFile();
		assertEquals(634316, bytesRead.intValue());
	}
}
