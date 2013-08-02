import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.client.main.ClientBuilder;

public class SampleTest {

	@Test
	public void testClientBuilder() {
		Client client;
		ClientBuilder builder = new ClientBuilder();
		client = builder.build();
		assertTrue(client != null);
	}

}
