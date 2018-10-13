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

import ru.projects.Shop.ejb.CommentEJB;
import ru.projects.Shop.entity.Comment;
import ru.projects.Shop.entity.Comments;

@Path("/comment")
@Stateless
public class CommentRestService {
	@Inject
	private CommentEJB commentEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createComment")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createComment(Comment comment) {
		if(comment.equals(null))
			throw new BadRequestException();
		commentEJB.createComment(comment);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(comment.getComment_ID().toString()).build();
		Response response=Response.created(adressUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findCommentById/{id}")
	public Response findCommentById(@PathParam("id") Long id) {
		Comment comment=commentEJB.findCommentById(id);
		if(comment.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(comment).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllComments")
	public Response findAllComments() {
		List<Comment> comments=commentEJB.findAllComment();
		Response response=Response.ok(comments).build();
		return response;
	}
	
	@Path("/updateComment")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateComment(Comment comment) {
		if(comment.equals(null))
			throw new BadRequestException();
		Comment updated=commentEJB.updateComment(comment);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteComment")
	public Response deleteComment(Comment comment) {
		if(comment.equals(null))
			throw new NotFoundException();
		commentEJB.deleteComment(comment);
		Response response=Response.noContent().build();
		return response;
	}
	

}
