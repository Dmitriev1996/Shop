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

import ru.projects.Shop.entity.Adress;
import ru.projects.Shop.entity.Comment;
import ru.projects.Shop.entity.Comments;

@Path("/comment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class CommentRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@POST
	public Response createComment(Comment comment) {
		if(comment.equals(null))
			throw new BadRequestException();
		em.persist(comment);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(comment.getComment_ID().toString()).build();
		return Response.created(adressUri).build();
	}
	
	@GET
	@Path("{id}")
	public Response findCommentById(@PathParam("id") Long id) {
		Comment comment=em.find(Comment.class, id);
		if(comment.equals(null))
			throw new NotFoundException();
		return Response.ok(comment).build();
	}
	
	@GET
	public Response findAllComments() {
		TypedQuery<Comment> query=em.createNamedQuery("findAllComment", Comment.class);
		Comments comments=new Comments(query.getResultList());
		return Response.ok(comments).build();
	}
	
	@POST
	public Response updateComment(Comment comment) {
		if(comment.equals(null))
			throw new BadRequestException();
		em.merge(comment);
		return Response.ok(comment).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteComment(@PathParam("id") Long id) {
		Comment comment=em.find(Comment.class, id);
		if(comment.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(comment));
		return Response.noContent().build();
	}
	

}
