import static org.junit.Assert.assertTrue;

import java.net.Socket;

import org.junit.Test;

import com.sirma.itt.javacourse.chat.server.UsersManager;
import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.main.ServerBuilder;
import com.sirma.itt.javacourse.chat.server.structures.Client;

public class SamleTest {

	@Test
	public void testServerBuilder() {
		Server server;
		ServerBuilder builder = new ServerBuilder();
		server = builder.build();
		assertTrue(server != null);
	}

	@Test
	public void testUsersManagerAddUserSuccessful() {
		UsersManager manager = new UsersManager();
		boolean added = manager.addUser(new Client(new Socket()));
		assertTrue(manager.getClientSet().size() == 1 && added);
	}

	@Test
	public void testUsersManagerAddUserFail() {
		UsersManager manager = new UsersManager();
		manager.addUser(new Client(new Socket()));
		boolean addedFirst = manager.addUser(new Client(new Socket()));
		boolean addedSecond = manager.addUser(new Client(new Socket()));
		assertTrue(manager.getClientSet().size() == 1 && !addedFirst && !addedSecond);
	}
}
