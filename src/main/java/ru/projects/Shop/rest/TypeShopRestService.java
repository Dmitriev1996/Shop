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

import ru.projects.Shop.ejb.TypeShopEJB;
import ru.projects.Shop.entity.TypeShop;

@Path("/typeShop")
@Stateless
public class TypeShopRestService {
	@Inject
	private TypeShopEJB typeShopEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createTypePShop")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createTypeShop(TypeShop typeShop) {
		if(typeShop.equals(null))
			throw new BadRequestException();
		typeShopEJB.createTypeShop(typeShop);
		URI typeShopUri=uriInfo.getAbsolutePathBuilder()
				.path(typeShop.getTypeShop_ID().toString()).build();
		Response response=Response.created(typeShopUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTypeShopById/{id}")
	public Response findTypeShopById(@PathParam("id") Long id) {
		TypeShop typeShop=typeShopEJB.findTypeShopById(id);
		if(typeShop.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(typeShop).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTypeShops")
	public Response findAllTypeShops() {
		List<TypeShop> typeShops=typeShopEJB.findAllTypeShop();
		Response response=Response.ok(typeShops).build();
		return response;
	}
	
	@Path("/updateTypeShop")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateTypeShop(TypeShop typeShop) {
		if(typeShop.equals(null))
			throw new BadRequestException();
		TypeShop updated=typeShopEJB.updateTypeShop(typeShop);
		Response response=Response.ok(typeShop).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTypeShop")
	public Response deleteTypeShop(TypeShop typeShop) {
		if(typeShop.equals(null))
			throw new NotFoundException();
		typeShopEJB.deleteTypeShop(typeShop);
		Response response=Response.noContent().build();
		return response;
	}

}
