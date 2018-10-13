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

import ru.projects.Shop.ejb.SexEJB;
import ru.projects.Shop.entity.Sex;

@Path("/sex")
@Stateless
public class SexRestService {
	@Inject
	private SexEJB sexEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createSex")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createSex(Sex sex) {
		if(sex.equals(null))
			throw new BadRequestException();
		sexEJB.createSex(sex);
		URI sexUri=uriInfo.getAbsolutePathBuilder()
				.path(sex.getSex_ID().toString()).build();
		Response response=Response.created(sexUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findSexById/{id}")
	public Response findSexById(@PathParam("id") Long id) {
		Sex sex=sexEJB.findSexById(id);
		if(sex.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(sex).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllSexes")
	public Response findAllSexes() {
		List<Sex> sexes=sexEJB.findAllSex();
		Response response=Response.ok(sexes).build();
		return response;
	}
	
	@Path("/updateSex")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateSex(Sex sex) {
		if(sex.equals(null))
			throw new BadRequestException();
		Sex updated=sexEJB.updateSex(sex);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteSex")
	public Response deleteSex(Sex sex) {
		if(sex.equals(null))
			throw new NotFoundException();
		sexEJB.deleteSex(sex);
		Response response=Response.noContent().build();
		return response;
	}

}
