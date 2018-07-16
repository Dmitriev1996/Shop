package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import ru.projects.Shop.ejb.CommentEJB;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Comment;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.Sex;
import ru.projects.Shop.entity.TypeProduct;

public class CommentTest extends ParentTest {
	
	@Test
	public void shouldComment() throws Exception {
		Comment comment=new Comment();
		Client client=new Client();
		client.setSurname("Дмитриев");
		client.setName("Александр");
		client.setPatronymic("Андреевич");
		client.setDateOfBirth(new Date(16, 02, 1996));
		Sex sex=new Sex();
		sex.setSex("Мужской");
		client.setSex(sex);
		comment.setClient(client);
		Product product=new Product();
		TypeProduct typeproduct=new TypeProduct();
		typeproduct.setTypeProduct("Молочные продукты");
		product.setTypeProduct(typeproduct);
		product.setNameOfProduct("Молоко");
		comment.setProduct(product);
		comment.setComment("Очень вкусное молоко!");
		CommentEJB commentejb=(CommentEJB)ctx.lookup("java:global/classes/CommentEJB!ru.projects.Shop.ejb.CommentEJB");
		commentejb.createComment(comment);
		assertEquals(1, commentejb.findAllComment().size());
		Comment controlcomment=commentejb.findCommentById(1L);
		controlcomment.setComment("Очень хорошее молоко!");
		commentejb.updateComment(controlcomment);
		Comment updated=commentejb.findCommentById(1L);
		assertEquals("Очень хорошее молоко!", updated.getComment());
		commentejb.deleteComment(updated);
		assertEquals(0, commentejb.findAllComment().size());
	}

}
