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

import ru.projects.Shop.entity.Adress;
import ru.projects.Shop.entity.Buy;
import ru.projects.Shop.entity.Buys;

@Path("/buy")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BuyRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@POST
	public Response createBuy(Buy buy) {
		if(buy.equals(null))
			throw new BadRequestException();
		em.persist(buy);
		URI buyUri=uriInfo.getAbsolutePathBuilder()
				.path(buy.getBuy_ID().toString()).build();
		return Response.created(buyUri).build();
	}
	
	@GET
	@Path("{id}")
	public Response findBuyById(@PathParam("id") Long id) {
		Buy buy=em.find(Buy.class, id);
		if(buy.equals(null))
			throw new NotFoundException();
		return Response.ok(buy).build();
	}
	
	@GET
	public Response findAllBuys() {
		TypedQuery<Buy> query=em.createNamedQuery("findAllBuy", Buy.class);
		Buys buys=new Buys(query.getResultList());
		return Response.ok(buys).build();
	}
	
	@POST
	public Response updateBuy(Buy buy) {
		if(buy.equals(null))
			throw new BadRequestException();
		em.merge(buy);
		return Response.ok(buy).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteBuy(@PathParam("id") Long id) {
		Buy buy=em.find(Buy.class, id);
		if(buy.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(buy));
		return Response.noContent().build();
	}
	

}
