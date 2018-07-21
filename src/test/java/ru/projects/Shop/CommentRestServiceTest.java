package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.projects.Shop.entity.Comment;
import ru.projects.Shop.entity.Comments;

public class CommentRestServiceTest {
	 private static URI uri = UriBuilder.fromUri("http://localhost/Shop/api/comment").port(8080).build();
	  private static Client client = ClientBuilder.newClient();

	  private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><comment><comment>Привет!</comment></comment>";
	  private static GlassFishRuntime runtime;
	  private static GlassFish gf;

	  @BeforeClass
	  public static void init() throws IOException, GlassFishException {
	    // for details on using embedded glassfish API see Embedded Glassfish Guide
	    // https://docs.oracle.com/cd/E18930_01/html/821-2424/gjldt.html#
	     runtime = GlassFishRuntime.bootstrap();
	     GlassFishProperties prop = new GlassFishProperties();
	     prop.setPort("http-listener", 8080);
	     gf = runtime.newGlassFish(prop);
	     gf.start();
	     String result = gf.getDeployer().deploy(new File("target/Shop-0.0.1-SNAPSHOT.war"));
	     System.out.println(gf.getStatus());
	     if (result == null) {
	         throw new IllegalStateException("Deployment failed");
	     }
	  }

	  @AfterClass
	  public static void stop() throws GlassFishException {
	    gf.stop();
	    gf.dispose();
	    runtime.shutdown();
	  }
	  
	  // ======================================
	  // =              Unit tests            =
	  // ======================================


	  @Test
	  public void shouldMarshallABook() throws JAXBException {
	    // given
	    Comment comment=new Comment();
	    comment.setComment("Привет!");
	    StringWriter writer = new StringWriter();
	    JAXBContext context = JAXBContext.newInstance(Comment.class);
	    Marshaller m = context.createMarshaller();
	    m.marshal(comment, writer);

	    // then
	    assertEquals(XML, writer.toString());
	  }

	  @Test
	  public void shouldMarshallAListOfBooks() throws JAXBException {
	    Comments comments=new Comments();
	    Comment comment;
	    comment=new Comment();
	    comment.setComment("Привет");
	    comments.add(comment);
	    comment=new Comment();
	    comment.setComment("Hello");
	    comments.add(comment);
	    StringWriter writer = new StringWriter();
	    JAXBContext context = JAXBContext.newInstance(Comments.class);
	    Marshaller m = context.createMarshaller();
	    m.marshal(comments, writer);
	  }


	  @Test
	  public void shouldCreateAndDeleteABook() throws JAXBException {

		Comment comment=new Comment();
		comment.setComment("Привет!");

	    // POSTs a Book
	    Response response = client.target(uri).path("/createComment").request().post(Entity.entity(comment, MediaType.APPLICATION_XML));
	    assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatusInfo().getStatusCode());
	    URI commentURI = response.getLocation();

	    // With the location, GETs the Book
	    response = client.target(uri).path("/1").request().get();
	    comment = response.readEntity(Comment.class);
	    assertEquals(Response.Status.OK.getStatusCode(), response.getStatusInfo().getStatusCode());
	    assertEquals("Привет!", comment.getComment());
	    

	    // Gets the book id and DELETEs it
	    //String commentId = uri.toString().split("/")[1];
	    response = client.target(uri).path("/1").request().delete();
	    assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatusInfo().getStatusCode());

	    // GETs the Book and checks it has been deleted
	    response = client.target(commentURI).request().get();
	    assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatusInfo().getStatusCode());

	  }

	  @Test
	  public void shouldNotCreateANullBook() throws JAXBException {

	    // POSTs a Null Book
	    Response response = client.target(uri).path("/createComment").request().post(Entity.entity(null, MediaType.APPLICATION_XML));
	    assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatusInfo().getStatusCode());
	  }

	  @Test
	  public void shouldNotFindTheBookID() throws JAXBException {

	    // GETs a Book with an unknown ID
	    Response response = client.target(uri).path("invalidID").request().get();
	    assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatusInfo().getStatusCode());
	  } 

}
