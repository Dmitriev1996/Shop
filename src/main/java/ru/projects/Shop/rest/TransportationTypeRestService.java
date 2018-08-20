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

import ru.projects.Shop.entity.TransportationType;
import ru.projects.Shop.entity.TransportationTypes;

@Path("/transportation_type")
@Stateless
public class TransportationTypeRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createTransportationType")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTransportationType(TransportationType transType) {
		if(transType.equals(null))
			throw new BadRequestException();
		em.persist(transType);
		URI transTypeUri=uriInfo.getAbsolutePathBuilder()
				.path(transType.getType_ID().toString()).build();
		return Response.created(transTypeUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTransportationTypeById/{id}")
	public Response findTransportationTypeById(@PathParam("id") Long id) {
		TransportationType transType=em.find(TransportationType.class, id);
		if(transType.equals(null))
			throw new NotFoundException();
		return Response.ok(transType).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTransportationTypes")
	public Response findAllTransportationTypes() {
		TypedQuery<TransportationType> query=em.createNamedQuery("findAllTransportationType", TransportationType.class);
		TransportationTypes transTypes=new TransportationTypes(query.getResultList());
		return Response.ok(transTypes).build();
	}
	
	@Path("/updateTransportationType")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateTransportationType(TransportationType transType) {
		if(transType.equals(null))
			throw new BadRequestException();
		em.merge(transType);
		return Response.ok(transType).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTransportationType/{id}")
	public Response deleteTransportationType(@PathParam("id") Long id) {
		TransportationType transType=em.find(TransportationType.class, id);
		if(transType.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(transType));
		return Response.noContent().build();
	}

}
