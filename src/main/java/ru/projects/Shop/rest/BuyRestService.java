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

import ru.projects.Shop.ejb.BuyEJB;
import ru.projects.Shop.entity.Buy;
import ru.projects.Shop.entity.Buys;

@Path("/buy")
@Stateless
public class BuyRestService {
	@Inject
	private BuyEJB buyEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createBuy")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createBuy(Buy buy) {
		if(buy.equals(null))
			throw new BadRequestException();
		buyEJB.createBuy(buy);
		URI buyUri=uriInfo.getAbsolutePathBuilder()
				.path(buy.getBuy_ID().toString()).build();
		Response response=Response.created(buyUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findBuyById/{id}")
	public Response findBuyById(@PathParam("id") Long id) {
		Buy buy=buyEJB.findBuyById(id);
		if(buy.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(buy).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllBuys")
	public Response findAllBuys() {
		List<Buy> buys=buyEJB.findAllBuy();
		Response response=Response.ok(buys).build();
		return response;
	}
	
	@Path("/updateBuy")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateBuy(Buy buy) {
		if(buy.equals(null))
			throw new BadRequestException();
		Buy updated=buyEJB.updateBuy(buy);
		Response response= Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteBuy")
	public Response deleteBuy(Buy buy) {
		buyEJB.deleteBuy(buy);
		Response response=Response.noContent().build();
		return response;
	}
	

}
