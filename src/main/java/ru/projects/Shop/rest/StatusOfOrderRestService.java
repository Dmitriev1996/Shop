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

import ru.projects.Shop.ejb.StatusOfOrderEJB;
import ru.projects.Shop.entity.StatusOfOrder;

@Path("/statusOfOrder")
@Stateless
public class StatusOfOrderRestService {
	@Inject
	private StatusOfOrderEJB statusOfOrderEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createStatusOfOrder")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createStatusOfOrder(StatusOfOrder statusOfOrder) {
		if(statusOfOrder.equals(null))
			throw new BadRequestException();
		statusOfOrderEJB.createStatusOfOrder(statusOfOrder);
		URI statusOfOrderUri=uriInfo.getAbsolutePathBuilder()
				.path(statusOfOrder.getStatus_ID().toString()).build();
		Response response=Response.created(statusOfOrderUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findStatusOfOrderById/{id}")
	public Response findStatusOfOrderById(@PathParam("id") Long id) {
		StatusOfOrder statusOfOrder=statusOfOrderEJB.findStatusOfOrderById(id);
		if(statusOfOrder.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(statusOfOrder).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllStatusOfOrders")
	public Response findAllStatusOfOrders() {
		List<StatusOfOrder> statusOfOrders=statusOfOrderEJB.findAllStatusOfOrder();
		Response response=Response.ok(statusOfOrders).build();
		return response;
	}
	
	@Path("/updateStatusOfOrder")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateStatusOfOrder(StatusOfOrder statusOfOrder) {
		if(statusOfOrder.equals(null))
			throw new BadRequestException();
		StatusOfOrder updated=statusOfOrderEJB.updateStatusOfOrder(statusOfOrder);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteStatusOfOrder")
	public Response deleteStatusOfOrder(StatusOfOrder statusOfOrder) {
		if(statusOfOrder.equals(null))
			throw new NotFoundException();
		statusOfOrderEJB.deleteStatusOfOrder(statusOfOrder);
		Response response=Response.noContent().build();
		return response;
	}

}
