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

import ru.projects.Shop.ejb.WarehouseEJB;
import ru.projects.Shop.entity.Warehouse;
import ru.projects.Shop.entity.Warehouses;

@Path("/warehouse")
@Stateless
public class WarehouseRestService {
	@Inject
	private WarehouseEJB warehouseEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createWarehouse")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createWarehouse(Warehouse warehouse) {
		if(warehouse.equals(null))
			throw new BadRequestException();
		warehouseEJB.createWarehouse(warehouse);
		URI warehouseUri=uriInfo.getAbsolutePathBuilder()
				.path(warehouse.getWarehouse_ID().toString()).build();
		Response response=Response.created(warehouseUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findWarehouseById/{id}")
	public Response findWarehouseById(@PathParam("id") Long id) {
		Warehouse warehouse=warehouseEJB.findWarehouseById(id);
		if(warehouse.equals(null))
			throw new NotFoundException();
		return Response.ok(warehouse).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllWarehouses")
	public Response findAllWarehouses() {
		List<Warehouse> warehouses=warehouseEJB.findAllWarehouse();
		Response response=Response.ok(warehouses).build();
		return response;
	}
	
	@Path("/updateWarehouse")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateWarehouse(Warehouse warehouse) {
		if(warehouse.equals(null))
			throw new BadRequestException();
		Warehouse updated=warehouseEJB.updateWarehouse(warehouse);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteWarehouse")
	public Response deleteWarehouse(Warehouse warehouse) {
		if(warehouse.equals(null))
			throw new NotFoundException();
		warehouseEJB.deleteWarehouse(warehouse);
		Response response=Response.noContent().build();
		return response;
	}

}
