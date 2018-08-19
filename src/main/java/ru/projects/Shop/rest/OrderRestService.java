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

import ru.projects.Shop.entity.Order;
import ru.projects.Shop.entity.Orders;

@Path("/order")
@Stateless
public class OrderRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createOrder")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createOrder(Order order) {
		if(order.equals(null))
			throw new BadRequestException();
		em.persist(order);
		URI orderUri=uriInfo.getAbsolutePathBuilder()
				.path(order.getOrder_ID().toString()).build();
		return Response.created(orderUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findOrderById/{id}")
	public Response findOrderById(@PathParam("id") Long id) {
		Order order=em.find(Order.class, id);
		if(order.equals(null))
			throw new NotFoundException();
		return Response.ok(order).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllOrders")
	public Response findAllOrders() {
		TypedQuery<Order> query=em.createNamedQuery("findAllOrder", Order.class);
		Orders orders=new Orders(query.getResultList());
		return Response.ok(orders).build();
	}
	
	@Path("/updateOrder")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateOrder(Order order) {
		if(order.equals(null))
			throw new BadRequestException();
		em.merge(order);
		return Response.ok(order).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteOrder/{id}")
	public Response deleteOrder(@PathParam("id") Long id) {
		Order order=em.find(Order.class, id);
		if(order.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(order));
		return Response.noContent().build();
	}

}
