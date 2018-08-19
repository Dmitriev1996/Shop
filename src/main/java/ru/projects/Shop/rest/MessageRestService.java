package ru.projects.Shop.rest;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ru.projects.Shop.entity.Message;
import ru.projects.Shop.entity.Messages;

@Path("/message")
@Stateless
public class MessageRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createMessage")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createMessage(Message message) {
		if(message.equals(null))
			throw new BadRequestException();
		em.persist(message);
		URI messageUri=uriInfo.getAbsolutePathBuilder()
				.path(message.getMessage_ID().toString()).build();
		return Response.created(messageUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findMessageById/{id}")
	public Response findMessageById(@PathParam("id") Long id) {
		Message message=em.find(Message.class, id);
		if(message.equals(null))
			throw new NotFoundException();
		return Response.ok(message).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllMessages")
	public Response findAllMessages() {
		TypedQuery<Message> query=em.createNamedQuery("findAllMessage", Message.class);
		Messages messages=new Messages(query.getResultList());
		return Response.ok(messages).build();
	}
	
	@Path("/updateMessage")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateMessage(Message message) {
		if(message.equals(null))
			throw new BadRequestException();
		em.merge(message);
		return Response.ok(message).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteMessage/{id}")
	public Response deleteMessage(@PathParam("id") Long id) {
		Message message=em.find(Message.class, id);
		if(message.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(message));
		return Response.noContent().build();
	}

}
