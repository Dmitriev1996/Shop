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

import ru.projects.Shop.entity.Sex;
import ru.projects.Shop.entity.Sexes;

@Path("/sex")
@Stateless
public class SexRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createSex")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createSex(Sex sex) {
		if(sex.equals(null))
			throw new BadRequestException();
		em.persist(sex);
		URI sexUri=uriInfo.getAbsolutePathBuilder()
				.path(sex.getSex_ID().toString()).build();
		return Response.created(sexUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findSexById/{id}")
	public Response findSexById(@PathParam("id") Long id) {
		Sex sex=em.find(Sex.class, id);
		if(sex.equals(null))
			throw new NotFoundException();
		return Response.ok(sex).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllSexes")
	public Response findAllSexes() {
		TypedQuery<Sex> query=em.createNamedQuery("findAllSex", Sex.class);
		Sexes sexes=new Sexes(query.getResultList());
		return Response.ok(sexes).build();
	}
	
	@Path("/updateSex")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateSex(Sex sex) {
		if(sex.equals(null))
			throw new BadRequestException();
		em.merge(sex);
		return Response.ok(sex).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteSex/{id}")
	public Response deleteSex(@PathParam("id") Long id) {
		Sex sex=em.find(Sex.class, id);
		if(sex.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(sex));
		return Response.noContent().build();
	}

}
