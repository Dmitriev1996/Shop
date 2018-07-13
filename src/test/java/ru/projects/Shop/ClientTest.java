package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.junit.Test;

import ru.projects.Shop.ejb.ClientEJB;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Sex;

@DataSourceDefinition(name = "java:global/jdbc/Shop",
className = "org.apache.derby.jdbc.EmbeddedDriver",
url = "jdbc:derby:memory:Shop;create=true;user=app;password=app"
)
@Singleton
@Startup
public class ClientTest {
	@Inject
	private ClientEJB clientejb=new ClientEJB();
	
	@Test
	public void shouldClient() throws Exception{
		Client client=new Client();
		client.setSurname("Дмитриев");
		client.setName("Александр");
		client.setPatronymic("Андреевич");
		Sex sex=new Sex();
		sex.setSex("Мужской");
		client.setSex(sex);
		assertEquals(null, clientejb);
		//clientejb.createClient(client);
		//Client controlclient=clientejb.findClientById(1L);
		//assertEquals("Дмитриев", client.getSurname());
	}

}
