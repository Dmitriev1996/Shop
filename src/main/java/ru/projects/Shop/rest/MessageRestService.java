package ru.projects.Shop.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

import ru.projects.Shop.ejb.MessageEJB;
import ru.projects.Shop.entity.Message;
import ru.projects.Shop.entity.Messages;

@Path("/message")
@Stateless
public class MessageRestService {
	@Inject
	private MessageEJB messageEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createMessage")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createMessage(Message message) {
		if(message.equals(null))
			throw new BadRequestException();
		messageEJB.createMessage(message);
		URI messageUri=uriInfo.getAbsolutePathBuilder()
				.path(message.getMessage_ID().toString()).build();
		Response response=Response.created(messageUri).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findMessageById/{id}")
	public Response findMessageById(@PathParam("id") Long id) {
		Message message=messageEJB.findMessageById(id);
		if(message.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(message).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllMessages")
	public Response findAllMessages() {
		List<Message> messages=messageEJB.findAllMesage();
		Response response=Response.ok(messages).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@Path("/updateMessage")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateMessage(Message message) {
		if(message.equals(null))
			throw new BadRequestException();
		Message updated=messageEJB.updateMessage(message);
		Response response=Response.ok(updated).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteMessage")
	public Response deleteMessage(Message message) {
		if(message.equals(null))
			throw new NotFoundException();
		messageEJB.deleteMessage(message);
		Response response=Response.noContent().build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}

}
