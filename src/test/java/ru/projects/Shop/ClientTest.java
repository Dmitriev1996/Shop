package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import ru.projects.Shop.ejb.ClientEJB;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Sex;

public class ClientTest {
	//@Inject
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
		clientejb.createClient(client);
		Client controlclient=clientejb.findClientById(1L);
		assertEquals("Дмитриев", client.getSurname());
	}

}
