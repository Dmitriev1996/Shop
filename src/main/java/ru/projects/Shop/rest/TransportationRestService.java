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

import ru.projects.Shop.entity.Transportation;
import ru.projects.Shop.entity.Transportations;

@Path("/transportation")
@Stateless
public class TransportationRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createTransportation")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTransportation(Transportation transportation) {
		if(transportation.equals(null))
			throw new BadRequestException();
		em.persist(transportation);
		URI transportationUri=uriInfo.getAbsolutePathBuilder()
				.path(transportation.getTransportation_ID().toString()).build();
		return Response.created(transportationUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTransportationById/{id}")
	public Response findTransportationById(@PathParam("id") Long id) {
		Transportation transportation=em.find(Transportation.class, id);
		if(transportation.equals(null))
			throw new NotFoundException();
		return Response.ok(transportation).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTransportations")
	public Response findAllTransportations() {
		TypedQuery<Transportation> query=em.createNamedQuery("findAllTransportation", Transportation.class);
		Transportations transportations=new Transportations(query.getResultList());
		return Response.ok(transportations).build();
	}
	
	@Path("/updateTransportation")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateTransportation(Transportation transportation) {
		if(transportation.equals(null))
			throw new BadRequestException();
		em.merge(transportation);
		return Response.ok(transportation).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTransportation/{id}")
	public Response deleteTransportation(@PathParam("id") Long id) {
		Transportation transportation=em.find(Transportation.class, id);
		if(transportation.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(transportation));
		return Response.noContent().build();
	}

}
