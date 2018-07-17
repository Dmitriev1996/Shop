package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.projects.Shop.ejb.ForumEJB;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Forum;
import ru.projects.Shop.entity.Message;
import ru.projects.Shop.entity.Sex;

public class ForumTest extends ParentTest {
	
	@Test
	public void shouldForum() throws Exception {
		Forum forum=new Forum();
		Client client=new Client();
		client.setSurname("Дмитриев");
		client.setName("Александр");
		client.setPatronymic("Андреевич");
		Sex sex=new Sex();
		sex.setSex("Мужской");
		client.setSex(sex);
		forum.setClient(client);
		forum.setNameOfForum("Песочница");
		List<Message> messagelist=new ArrayList<Message>();
		Message message;
		message=new Message();
		message.setClient(client);
		message.setMessage("Всем привет!");
		message.setDateOfMessage(new Date(17, 07, 2018));
		messagelist.add(message);
		message=new Message();
		message.setClient(client);
		message.setMessage("Как дела?");
		message.setDateOfMessage(new Date(17, 07, 2018));
		messagelist.add(message);
		forum.setMessageList(messagelist);
		ForumEJB forumejb=(ForumEJB)ctx.lookup("java:global/classes/ForumEJB!ru.projects.Shop.ejb.ForumEJB");
		forumejb.createForum(forum);
		assertEquals(1, forumejb.findAllForum().size());
		Forum controlforum=forumejb.findForumById(1L);
		controlforum.setNameOfForum("Флудилка");
		forumejb.updateForum(controlforum);
		Forum updated=forumejb.findForumById(1L);
		assertEquals("Флудилка", updated.getNameOfForum());
		forumejb.deleteForum(updated);
		assertEquals(0, forumejb.findAllForum().size());
	}

}
