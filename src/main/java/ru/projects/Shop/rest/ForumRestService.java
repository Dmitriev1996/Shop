package ru.projects.Shop.rest;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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

import ru.projects.Shop.entity.Forum;

@Path("/forum")
@Stateless
public class ForumRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createForum")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createForum(Forum forum) {
		if(forum.equals(null))
			throw new BadRequestException();
		em.persist(forum);
		URI forumUri=uriInfo.getAbsolutePathBuilder()
				.path(forum.getForum_ID().toString()).build();
		return Response.created(forumUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findForumById/{id}")
	public Response findForumById(@PathParam("id") Long id) {
		Forum forum=em.find(Forum.class, id);
		if(forum.equals(null))
			throw new NotFoundException();
		return Response.ok(forum).build();
	}
	
	@Path("/updateForum")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateForum(Forum forum) {
		if(forum.equals(null))
			throw new BadRequestException();
		em.merge(forum);
		return Response.ok(forum).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteForum/{id}")
	public Response deleteForum(@PathParam("id") Long id) {
		Forum forum=em.find(Forum.class, id);
		if(forum.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(forum));
		return Response.noContent().build();
	}

}
