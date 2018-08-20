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

import ru.projects.Shop.entity.Warehouse;
import ru.projects.Shop.entity.Warehouses;

@Path("/warehouse")
@Stateless
public class WarehouseRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createWarehouse")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createWarehouse(Warehouse warehouse) {
		if(warehouse.equals(null))
			throw new BadRequestException();
		em.persist(warehouse);
		URI warehouseUri=uriInfo.getAbsolutePathBuilder()
				.path(warehouse.getWarehouse_ID().toString()).build();
		return Response.created(warehouseUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findWarehouseById/{id}")
	public Response findWarehouseById(@PathParam("id") Long id) {
		Warehouse warehouse=em.find(Warehouse.class, id);
		if(warehouse.equals(null))
			throw new NotFoundException();
		return Response.ok(warehouse).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllWarehouses")
	public Response findAllWarehouses() {
		TypedQuery<Warehouse> query=em.createNamedQuery("findAllWarehouse", Warehouse.class);
		Warehouses warehouses=new Warehouses(query.getResultList());
		return Response.ok(warehouses).build();
	}
	
	@Path("/updateWarehouse")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateWarehouse(Warehouse warehouse) {
		if(warehouse.equals(null))
			throw new BadRequestException();
		em.merge(warehouse);
		return Response.ok(warehouse).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteWarehouse/{id}")
	public Response deleteWarehouse(@PathParam("id") Long id) {
		Warehouse warehouse=em.find(Warehouse.class, id);
		if(warehouse.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(warehouse));
		return Response.noContent().build();
	}

}
