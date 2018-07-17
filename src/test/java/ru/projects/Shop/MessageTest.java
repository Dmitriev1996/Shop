package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import ru.projects.Shop.ejb.MessageEJB;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Message;
import ru.projects.Shop.entity.Sex;

public class MessageTest extends ParentTest {
	
	@Test
	public void shouldMessage() throws Exception {
		Message message=new Message();
		message.setDateOfMessage(new Date(17, 07, 2018));
		Client client=new Client();
		client.setSurname("Дмитриев");
		client.setName("Александр");
		client.setPatronymic("Андреевич");
		Sex sex=new Sex();
		sex.setSex("Мужской");
		client.setSex(sex);
		message.setClient(client);
		message.setMessage("Всем привет!");
		MessageEJB messageejb=(MessageEJB)ctx.lookup("java:global/classes/MessageEJB!ru.projects.Shop.ejb.MessageEJB");
		messageejb.createMessage(message);
		assertEquals(1, messageejb.findAllMesage().size());
		Message controlmessage=messageejb.findMessageById(1L);
		controlmessage.setMessage("Всем здравствуйте!");
		messageejb.updateMessage(controlmessage);
		Message updated=messageejb.findMessageById(1L);
		assertEquals("Всем здравствуйте!", updated.getMessage());
		messageejb.deleteMessage(updated);
		assertEquals(0, messageejb.findAllMesage().size());
	}

}
