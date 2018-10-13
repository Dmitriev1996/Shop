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

import ru.projects.Shop.ejb.DeliveryEJB;
import ru.projects.Shop.entity.Deliveries;
import ru.projects.Shop.entity.Delivery;

@Path("/delivery")
@Stateless
public class DeliveryRestService {
	@Inject
	private DeliveryEJB deliveryEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createDelivery")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createDelivery(Delivery delivery) {
		if(delivery.equals(null))
			throw new BadRequestException();
		deliveryEJB.createDelivery(delivery);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(delivery.getDelivery_ID().toString()).build();
		Response response=Response.created(adressUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findDeliveryById/{id}")
	public Response findDeliveryById(@PathParam("id") Long id) {
		Delivery delivery=deliveryEJB.findDeliveryById(id);
		if(delivery.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(delivery).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllDeliveries")
	public Response findAllDeliveries() {
		List<Delivery> deliveries=deliveryEJB.findAllDelivery();
		Response response=Response.ok(deliveries).build();
		return response;
	}
	
	@Path("/updateDelivery")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateDelivery(Delivery delivery) {
		if(delivery.equals(null))
			throw new BadRequestException();
		Delivery updated=deliveryEJB.updateDelivery(delivery);
		Response response=Response.ok(delivery).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteDelivery")
	public Response deleteDelivery(Delivery delivery) {
		if(delivery.equals(null))
			throw new NotFoundException();
		deliveryEJB.deleteDelivery(delivery);
	    Response response=Response.noContent().build();
	    return response;
	}

}
