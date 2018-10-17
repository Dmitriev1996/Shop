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

import ru.projects.Shop.ejb.ShopEJB;
import ru.projects.Shop.entity.Shop;

@Path("/shop")
@Stateless
public class ShopRestService {
	@Inject
	private ShopEJB shopEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createShop")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createShop(Shop shop) {
		if(shop.equals(null))
			throw new BadRequestException();
		shopEJB.createShop(shop);
		URI shopUri=uriInfo.getAbsolutePathBuilder()
				.path(shop.getShop_ID().toString()).build();
		Response response=Response.created(shopUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findShopById/{id}")
	public Response findShopById(@PathParam("id") Long id) {
		Shop shop=shopEJB.findShopById(id);
		if(shop.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(shop).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllShops")
	public Response findAllShops() {
		List<Shop> shops=shopEJB.findAllShop();
		Response response=Response.ok(shops).build();
		return response;
	}
	
	@Path("/updateShop")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateShop(Shop shop) {
		if(shop.equals(null))
			throw new BadRequestException();
		Shop updated=shopEJB.updateShop(shop);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteShop")
	public Response deleteShop(Shop shop) {
		if(shop.equals(null))
			throw new NotFoundException();
		shopEJB.deleteShop(shop);
		Response response=Response.noContent().build();
		return response;
	}

}
