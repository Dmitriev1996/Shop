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

import ru.projects.Shop.ejb.OrderEJB;
import ru.projects.Shop.entity.Order;

@Path("/order")
@Stateless
public class OrderRestService {
	@Inject
	private OrderEJB orderEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createOrder")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createOrder(Order order) {
		if(order.equals(null))
			throw new BadRequestException();
		orderEJB.createOrder(order);
		URI orderUri=uriInfo.getAbsolutePathBuilder()
				.path(order.getOrder_ID().toString()).build();
		Response response=Response.created(orderUri).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findOrderById/{id}")
	public Response findOrderById(@PathParam("id") Long id) {
		Order order=orderEJB.findOrderById(id);
		if(order.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(order).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllOrders")
	public Response findAllOrders() {
		List<Order> orders=orderEJB.findAllOrder();
		Response response=Response.ok(orders).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@Path("/updateOrder")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateOrder(Order order) {
		if(order.equals(null))
			throw new BadRequestException();
		Order updated=orderEJB.updateOrder(order);
		Response response=Response.ok(updated).build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteOrder")
	public Response deleteOrder(Order order) {
		if(order.equals(null))
			throw new NotFoundException();
		orderEJB.deleteOrder(order);
		Response response=Response.noContent().build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}

}
