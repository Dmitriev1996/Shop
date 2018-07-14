package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.projects.Shop.ejb.ClientEJB;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Sex;


public class ClientTest {
	private static EJBContainer ec;
	private static Context ctx;
	
	  @BeforeClass
	  public static void initContainer() throws Exception {
	    Map<String, Object> properties = new HashMap<String, Object>();
	    properties.put(EJBContainer.MODULES, new File("target/classes"));
	    ec = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
	    ctx = ec.getContext();
	  }

	  @AfterClass
	  public static void closeContainer() throws Exception {
	    if (ctx != null)
	      ctx.close();
	    if (ec != null)
	      ec.close();
	  }
	
	@Test
	public void shouldClient() throws Exception{
		Client client=new Client();
		client.setSurname("Дмитриев");
		client.setName("Александр");
		client.setPatronymic("Андреевич");
		Sex sex=new Sex();
		sex.setSex("Мужской");
		client.setSex(sex);
		ClientEJB clientejb=(ClientEJB)ctx.lookup("java:global/classes/ClientEJB!ru.projects.Shop.ejb.ClientEJB");
		clientejb.createClient(client);
		assertEquals(1, clientejb.findAllClient().size());
		Client controlclient=clientejb.findClientById(1L);
		assertEquals("Мужской", controlclient.getSex().getSex());
		controlclient.setSurname("Петров");
		clientejb.updateClient(controlclient);
		Client updated=clientejb.findClientById(1L);
		assertEquals("Петров", updated.getSurname());
		Client deleted=clientejb.findClientById(1L);
		clientejb.deleteClient(deleted);
		assertEquals(0, clientejb.findAllClient().size());
	}

}
