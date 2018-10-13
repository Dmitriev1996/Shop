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

import ru.projects.Shop.ejb.RegionEJB;
import ru.projects.Shop.entity.Region;

@Path("/region")
@Stateless
public class RegionRestService {
	@Inject
	private RegionEJB regionEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createRegion")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createRegion(Region region) {
		if(region.equals(null))
			throw new BadRequestException();
		regionEJB.createRegion(region);
		URI regionUri=uriInfo.getAbsolutePathBuilder()
				.path(region.getRegion_ID().toString()).build();
		Response response=Response.created(regionUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findRegionById/{id}")
	public Response findRegionById(@PathParam("id") Long id) {
		Region region=regionEJB.findRegionById(id);
		if(region.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(region).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllRegions")
	public Response findAllRegions() {
		List<Region> regions=regionEJB.findAllRegion();
		Response response=Response.ok(regions).build();
		return response;
	}
	
	@Path("/updateRegion")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateRegion(Region region) {
		if(region.equals(null))
			throw new BadRequestException();
		Region updated=regionEJB.updateRegion(region);
		Response response=Response.ok(region).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteRegion")
	public Response deleteRegion(Region region) {
		if(region.equals(null))
			throw new NotFoundException();
		regionEJB.deleteRegion(region);
		Response response=Response.noContent().build();
		return response;
	}

}
