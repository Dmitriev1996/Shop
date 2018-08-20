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

import ru.projects.Shop.entity.StatusOfOrder;
import ru.projects.Shop.entity.StatusOfOrders;

@Path("/status_of_order")
@Stateless
public class StatusOfOrderRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createStatusOfOrder")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createStatusOfOrder(StatusOfOrder statusOfOrder) {
		if(statusOfOrder.equals(null))
			throw new BadRequestException();
		em.persist(statusOfOrder);
		URI statusOfOrderUri=uriInfo.getAbsolutePathBuilder()
				.path(statusOfOrder.getStatus_ID().toString()).build();
		return Response.created(statusOfOrderUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findStatusOfOrderById/{id}")
	public Response findStatusOfOrderById(@PathParam("id") Long id) {
		StatusOfOrder statusOfOrder=em.find(StatusOfOrder.class, id);
		if(statusOfOrder.equals(null))
			throw new NotFoundException();
		return Response.ok(statusOfOrder).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllStatusOfOrders")
	public Response findAllStatusOfOrders() {
		TypedQuery<StatusOfOrder> query=em.createNamedQuery("findAllStatusOfOrder", StatusOfOrder.class);
		StatusOfOrders statusOfOrders=new StatusOfOrders(query.getResultList());
		return Response.ok(statusOfOrders).build();
	}
	
	@Path("/updateStatusOfOrder")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateStatusOfOrder(StatusOfOrder statusOfOrder) {
		if(statusOfOrder.equals(null))
			throw new BadRequestException();
		em.merge(statusOfOrder);
		return Response.ok(statusOfOrder).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteStatusOfOrder/{id}")
	public Response deleteStatusOfOrder(@PathParam("id") Long id) {
		StatusOfOrder statusOfOrder=em.find(StatusOfOrder.class, id);
		if(statusOfOrder.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(statusOfOrder));
		return Response.noContent().build();
	}

}
