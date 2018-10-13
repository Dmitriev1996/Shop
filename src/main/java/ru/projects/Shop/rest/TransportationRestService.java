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

import ru.projects.Shop.ejb.TransportationEJB;
import ru.projects.Shop.entity.Transportation;

@Path("/transportation")
@Stateless
public class TransportationRestService {
	@Inject
	private TransportationEJB transportationEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createTransportation")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTransportation(Transportation transportation) {
		if(transportation.equals(null))
			throw new BadRequestException();
		transportationEJB.createTransportation(transportation);
		URI transportationUri=uriInfo.getAbsolutePathBuilder()
				.path(transportation.getTransportation_ID().toString()).build();
		Response response=Response.created(transportationUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTransportationById/{id}")
	public Response findTransportationById(@PathParam("id") Long id) {
		Transportation transportation=transportationEJB.findTransportationById(id);
		if(transportation.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(transportation).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTransportations")
	public Response findAllTransportations() {
		List<Transportation> transportations=transportationEJB.findAllTransportation();
		Response response=Response.ok(transportations).build();
		return response;
	}
	
	@Path("/updateTransportation")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateTransportation(Transportation transportation) {
		if(transportation.equals(null))
			throw new BadRequestException();
		Transportation updated=transportationEJB.updateTransportation(transportation);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTransportation")
	public Response deleteTransportation(Transportation transportation) {
		if(transportation.equals(null))
			throw new NotFoundException();
		transportationEJB.deleteTransportation(transportation);
		Response response=Response.noContent().build();
		return response;
	}

}
