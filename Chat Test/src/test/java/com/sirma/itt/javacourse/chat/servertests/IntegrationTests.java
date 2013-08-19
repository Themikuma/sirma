package com.sirma.itt.javacourse.chat.servertests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.javacourse.chat.client.connectioncomponents.ClientConnectionUnit;
import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.client.maincomponents.ClientMainUnit;
import com.sirma.itt.javacourse.chat.server.connectioncomponents.ServerConnectionUnit;
import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerMainUnit;

/**
 * Integration tests for the server.
 * 
 * @author user
 */
@RunWith(MockitoJUnitRunner.class)
public class IntegrationTests {

	private Server server;
	private Client client;
	@Mock
	private ServerMainUnit serverMainUnit;
	@Mock
	private ClientMainUnit clientMainUnit;
	@Mock
	private ClientConnectionUnit clientConnectionUnit;
	@Mock
	private ServerConnectionUnit serverConnectionUnit;

	/**
	 * Sets up the server and client objects before each test. This does not start them, just
	 * constructs them.
	 */
	@Before
	public void setUp() {

		server = new Server.ServerBuilder().setConnectionUnit(serverConnectionUnit)
				.setMainUnit(serverMainUnit).build();
		client = new Client.Builder().setConnectionFrame(clientConnectionUnit)
				.setMainUnit(clientMainUnit).build();

	}

	/**
	 * Closes all opened connections after each test. Catches a null pointer exception because not
	 * all tests open a connection.
	 * 
	 * @throws IOException
	 *             if IO exception occurs while trying to close the connections
	 */
	@After
	public void tearDown() throws IOException {
		try {
			server.getServer().close();
			client.getServer().closeConnection();
		} catch (NullPointerException e) {

		}
		server = null;
		client = null;
	}

	/**
	 * Test a successfully established connection.
	 * 
	 * @throws InterruptedException
	 *             if something interrupts the sleep call
	 */
	@Test
	public void testServerConnectionSuccessful() throws InterruptedException {

		server.startServer("1");
		Thread.sleep(100);
		Mockito.verify(serverConnectionUnit).connectionEstablished();
		assertTrue(server.isRunning());
	}

	/**
	 * Test a failed connection with a used port error.
	 * 
	 * @throws InterruptedException
	 *             if something interrupts the sleep call
	 */
	@Test
	public void testServerConnectionUsedPort() throws InterruptedException {
		server.startServer("1");
		Thread.sleep(100);
		server.startServer("1");
		Thread.sleep(100);
		Mockito.verify(serverConnectionUnit).connectionRefused("usedPort");
	}

	/**
	 * Test a failed connection with a malformed port.
	 */
	@Test
	public void testServerConnectionMalformedPort() {
		server.startServer("qwt");
		Mockito.verify(serverConnectionUnit).connectionRefused("malformedPort");
	}

	/**
	 * Test a successful user connection.
	 * 
	 * @throws InterruptedException
	 *             if something interrupts the sleep call
	 */
	@Test
	public void testServerUserConnection() throws InterruptedException {
		server.startServer("1");
		Thread.sleep(100);
		client.tryConnect("", "asd", "1");
		Thread.sleep(100);
		Mockito.verify(serverMainUnit).onUserAdded("asd");
	}

	/**
	 * Test a successful user disconnection.
	 * 
	 * @throws InterruptedException
	 *             if something interrupts the sleep call
	 * @throws IOException
	 *             If an io exception occurs while trying to close the connection from the client.
	 */
	@Test
	public void testServerUserDisconnection() throws InterruptedException, IOException {
		server.startServer("1");
		Thread.sleep(100);
		client.tryConnect("", "asd", "1");
		Thread.sleep(100);
		client.getServer().getSocket().close();
		Thread.sleep(100);
		Mockito.verify(serverMainUnit).onUserRemoved("asd");
	}

	/**
	 * Test a successful receiving of a message from the client.
	 * 
	 * @throws InterruptedException
	 *             if something interrupts the sleep call
	 */
	@Test
	public void testServerUserMessage() throws InterruptedException {
		server.startServer("1");
		Thread.sleep(100);
		client.tryConnect("", "asd", "1");
		Thread.sleep(100);
		client.getServer().sendMessage("CLIENT_MESSAGE|hello");
		Thread.sleep(100);
		Mockito.verify(serverMainUnit).onMessageAdded("asd", "hello");
	}

	/**
	 * Test a successful stop of the server.
	 * 
	 * @throws IOException
	 *             if an io exception occurs while trying to stop the server
	 * @throws InterruptedException
	 *             if something interrupts the sleep call
	 */
	@Test
	public void testServerStop() throws IOException, InterruptedException {
		server.startServer("1");
		Thread.sleep(100);
		server.stopServer();
		assertTrue(server.getServer().isClosed());
	}
}
