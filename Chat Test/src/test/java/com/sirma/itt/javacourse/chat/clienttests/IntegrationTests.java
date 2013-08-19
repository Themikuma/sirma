package com.sirma.itt.javacourse.chat.clienttests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.client.maincomponents.ClientMainUnit;
import com.sirma.itt.javacourse.chat.connectionconfigs.ClientConnectionUnit;
import com.sirma.itt.javacourse.chat.server.connectionconfigs.ServerConnectionUnit;
import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerMainUnit;

/**
 * Integration tests for the client.
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
	 * Set up the server and client objects before each test.
	 * 
	 * @throws IOException
	 */
	@Before
	public void setUp() {

		server = new Server.ServerBuilder().setConnectionUnit(serverConnectionUnit)
				.setMainUnit(serverMainUnit).build();

		client = new Client.Builder().setConnectionFrame(clientConnectionUnit)
				.setMainUnit(clientMainUnit).build();

	}

	/**
	 * Close all connections and null out the server and client objects. Catch
	 * {@link NullPointerException} because not every test opens both connections.
	 * 
	 * @throws IOException
	 *             an io exception occured while trying to close the connections
	 */
	@After
	public void tearDown() throws IOException {
		try {
			server.getServer().close();
			client.getServer().getSocket().close();
		} catch (NullPointerException e) {

		}
		server = null;
		client = null;
	}

	/**
	 * Test for a successfully established connection to the server.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 */
	@Test
	public void testConnectionEstablished() throws InterruptedException {
		server.startServer("1");
		Thread.sleep(100);
		client.tryConnect("", "asd", "1");
		Thread.sleep(100);
		Mockito.verify(clientConnectionUnit).connectionEstablished();
	}

	/**
	 * Test for a failed connection to the server with an invalid username.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 */
	@Test
	public void testConnectionRefusedName() throws InterruptedException {
		server.startServer("1");
		Thread.sleep(100);
		client.tryConnect("", "asd[", "1");
		Thread.sleep(100);
		Mockito.verify(clientConnectionUnit).connectionRefused("username");
	}

	/**
	 * Test for a failed connection to the server with an invalid port range.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 */
	@Test
	public void testConnectionRefusedPortRange() throws InterruptedException {
		client.tryConnect("", "asd", "700000");
		Thread.sleep(100);
		Mockito.verify(clientConnectionUnit).connectionRefused("rangePort");
	}

	/**
	 * Test for a failed connection to the server with an invalid host name.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 */
	@Test
	public void testConnectionRefusedHost() throws InterruptedException {
		client.tryConnect("ase", "asd", "1");
		Thread.sleep(5000);
		Mockito.verify(clientConnectionUnit).connectionRefused("host");
	}

	/**
	 * Test the connection with two clients, one of which will have to be notified when the other
	 * connects.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 * @throws IOException
	 *             an io exception occured while trying to close the connections
	 */
	@Test
	public void testClientConnection() throws InterruptedException, IOException {
		server.startServer("1");
		Thread.sleep(100);

		ClientConnectionUnit clientConnectionUnitTwo = Mockito.mock(ClientConnectionUnit.class);
		ClientMainUnit clientMainUnitTwo = Mockito.mock(ClientMainUnit.class);
		Client clientTwo = new Client.Builder().setConnectionFrame(clientConnectionUnitTwo)
				.setMainUnit(clientMainUnitTwo).build();

		client.tryConnect("", "asd", "1");
		Thread.sleep(100);
		clientTwo.tryConnect("", "key", "1");
		Thread.sleep(100);

		Mockito.verify(clientMainUnit, Mockito.atLeastOnce()).onUserAdded("key");

		clientTwo.getServer().getSocket().close();
	}

	/**
	 * Test the sending of messages by connecting two clients. One of them sends a message to the
	 * server and the other one should be notified about it.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 * @throws IOException
	 *             an io exception occured while trying to close the connections
	 */
	@Test
	public void testClientMessage() throws InterruptedException, IOException {
		server.startServer("1");
		Thread.sleep(100);

		ClientConnectionUnit clientConnectionUnitTwo = Mockito.mock(ClientConnectionUnit.class);
		ClientMainUnit clientMainUnitTwo = Mockito.mock(ClientMainUnit.class);
		Client clientTwo = new Client.Builder().setConnectionFrame(clientConnectionUnitTwo)
				.setMainUnit(clientMainUnitTwo).build();

		client.tryConnect("", "asd", "1");
		clientTwo.tryConnect("", "key", "1");
		Thread.sleep(100);
		clientTwo.getServer().sendMessage("CLIENT_MESSAGE|hello");
		Thread.sleep(100);
		Mockito.verify(clientMainUnit).onMessageAdded("key", "hello");
		Mockito.verify(clientMainUnitTwo).onMessageAdded("key", "hello");
		clientTwo.getServer().getSocket().close();
	}

	/**
	 * Test the sending of messages with an invalid length (more than 200). The server will receive
	 * the message but should just ignore it.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 */
	@Test
	public void testClientLongMessage() throws InterruptedException {
		String message = "";
		for (int i = 0; i < 500; i++) {
			message += i;
		}
		server.startServer("1");
		Thread.sleep(100);
		client.tryConnect("", "asd", "1");
		Thread.sleep(100);
		client.getServer().sendMessage("CLIENT_MESSAGE|" + message);
		Mockito.verify(serverMainUnit, Mockito.never()).onMessageAdded("asd", message);
	}

	/**
	 * Test the sending of messages with an invalid length (0, empty message). The server will
	 * receive the message but should just ignore it.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 */
	@Test
	public void testClientEmptyMessage() throws InterruptedException {
		server.startServer("1");
		Thread.sleep(100);
		client.tryConnect("", "asd", "1");
		Thread.sleep(100);
		client.getServer().sendMessage("CLIENT_MESSAGE|");
		Thread.sleep(100);
		Mockito.verify(serverMainUnit, Mockito.never()).onMessageAdded("asd", "");
	}

	/**
	 * Test the disconnection of a client. When a client leaves the other connected clients should
	 * be notified about it.
	 * 
	 * @throws InterruptedException
	 *             if the sleep is interrupted
	 * @throws IOException
	 *             an io exception occured while trying to close the connections
	 */
	@Test
	public void testClientRemoved() throws InterruptedException, IOException {
		server.startServer("1");
		Thread.sleep(100);

		ClientConnectionUnit clientConnectionUnitTwo = Mockito.mock(ClientConnectionUnit.class);
		ClientMainUnit clientMainUnitTwo = Mockito.mock(ClientMainUnit.class);
		Client clientTwo = new Client.Builder().setConnectionFrame(clientConnectionUnitTwo)
				.setMainUnit(clientMainUnitTwo).build();

		client.tryConnect("", "asd", "1");
		clientTwo.tryConnect("", "key", "1");
		Thread.sleep(100);
		clientTwo.getServer().getSocket().close();
		Thread.sleep(100);
		Mockito.verify(clientMainUnit).onUserRemoved("key");

		clientTwo.getServer().getSocket().close();
	}

}
