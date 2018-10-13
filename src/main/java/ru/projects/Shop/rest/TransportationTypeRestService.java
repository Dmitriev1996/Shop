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

import ru.projects.Shop.ejb.TransportationTypeEJB;
import ru.projects.Shop.entity.TransportationType;

@Path("/transportationType")
@Stateless
public class TransportationTypeRestService {
	@Inject
	private TransportationTypeEJB transportationTypeEJB;;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createTransportationType")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTransportationType(TransportationType transType) {
		if(transType.equals(null))
			throw new BadRequestException();
		transportationTypeEJB.createTransportationType(transType);
		URI transTypeUri=uriInfo.getAbsolutePathBuilder()
				.path(transType.getType_ID().toString()).build();
		Response response=Response.created(transTypeUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTransportationTypeById/{id}")
	public Response findTransportationTypeById(@PathParam("id") Long id) {
		TransportationType transType=transportationTypeEJB.findTransportationTypeById(id);
		if(transType.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(transType).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTransportationTypes")
	public Response findAllTransportationTypes() {
		List<TransportationType> transTypes=transportationTypeEJB.findAllTransportationType();
		Response response=Response.ok(transTypes).build();
		return response;
	}
	
	@Path("/updateTransportationType")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateTransportationType(TransportationType transType) {
		if(transType.equals(null))
			throw new BadRequestException();
		TransportationType updated=transportationTypeEJB
				.updateTransportationType(transType);
		Response response=Response.ok(transType).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTransportationType")
	public Response deleteTransportationType(TransportationType transType) {
		if(transType.equals(null))
			throw new NotFoundException();
		transportationTypeEJB.deleteTransportationType(transType);
		Response response=Response.noContent().build();
		return response;
	}

}
