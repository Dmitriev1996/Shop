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

import ru.projects.Shop.entity.Deliveries;
import ru.projects.Shop.entity.Delivery;

@Path("/delivery")
@Stateless
public class DeliveryRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createDelivery")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createDelivery(Delivery delivery) {
		if(delivery.equals(null))
			throw new BadRequestException();
		em.persist(delivery);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(delivery.getDelivery_ID().toString()).build();
		return Response.created(adressUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findDeliveryById/{id}")
	public Response findDeliveryById(@PathParam("id") Long id) {
		Delivery delivery=em.find(Delivery.class, id);
		if(delivery.equals(null))
			throw new NotFoundException();
		return Response.ok(delivery).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllDeliveries")
	public Response findAllDeliveries() {
		TypedQuery<Delivery> query=em.createNamedQuery("findAllDelivery", Delivery.class);
		Deliveries deliveries=new Deliveries(query.getResultList());
		return Response.ok(deliveries).build();
	}
	
	@Path("/updateDelivery")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateDelivery(Delivery delivery) {
		if(delivery.equals(null))
			throw new BadRequestException();
		em.merge(delivery);
		return Response.ok(delivery).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteDelivery/{id}")
	public Response deleteDelivery(@PathParam("id") Long id) {
		Delivery delivery=em.find(Delivery.class, id);
		if(delivery.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(delivery));
		return Response.noContent().build();
	}

}
