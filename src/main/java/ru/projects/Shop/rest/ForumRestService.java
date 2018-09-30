package ru.projects.Shop.rest;

import java.net.URI;

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

import ru.projects.Shop.ejb.ForumEJB;
import ru.projects.Shop.entity.Forum;

@Path("/forum")
@Stateless
public class ForumRestService {
	@Inject
	private ForumEJB forumEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createForum")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createForum(Forum forum) {
		if(forum.equals(null))
			throw new BadRequestException();
		forumEJB.createForum(forum);
		URI forumUri=uriInfo.getAbsolutePathBuilder()
				.path(forum.getForum_ID().toString()).build();
		Response response=Response.created(forumUri).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findForumById/{id}")
	public Response findForumById(@PathParam("id") Long id) {
		Forum forum=forumEJB.findForumById(id);
		if(forum.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(forum).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@Path("/updateForum")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateForum(Forum forum) {
		if(forum.equals(null))
			throw new BadRequestException();
		Forum updated=forumEJB.updateForum(forum);
		Response response=Response.ok(updated).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteForum")
	public Response deleteForum(Forum forum) {
		if(forum.equals(null))
			throw new NotFoundException();
		forumEJB.deleteForum(forum);
		Response response=Response.noContent().build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}

}
