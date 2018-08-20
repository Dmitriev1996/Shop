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

import ru.projects.Shop.entity.Region;
import ru.projects.Shop.entity.Regions;

@Path("/region")
@Stateless
public class RegionRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createRegion")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createRegion(Region region) {
		if(region.equals(null))
			throw new BadRequestException();
		em.persist(region);
		URI regionUri=uriInfo.getAbsolutePathBuilder()
				.path(region.getRegion_ID().toString()).build();
		return Response.created(regionUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findRegionById/{id}")
	public Response findRegionById(@PathParam("id") Long id) {
		Region region=em.find(Region.class, id);
		if(region.equals(null))
			throw new NotFoundException();
		return Response.ok(region).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllRegions")
	public Response findAllRegions() {
		TypedQuery<Region> query=em.createNamedQuery("findAllRegion", Region.class);
		Regions regions=new Regions(query.getResultList());
		return Response.ok(regions).build();
	}
	
	@Path("/updateRegion")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateRegion(Region region) {
		if(region.equals(null))
			throw new BadRequestException();
		em.merge(region);
		return Response.ok(region).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteRegion/{id}")
	public Response deleteRegion(@PathParam("id") Long id) {
		Region region=em.find(Region.class, id);
		if(region.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(region));
		return Response.noContent().build();
	}

}
