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

import ru.projects.Shop.entity.Shop;
import ru.projects.Shop.entity.Shops;

@Path("/shop")
@Stateless
public class ShopRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createShop")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createShop(Shop shop) {
		if(shop.equals(null))
			throw new BadRequestException();
		em.persist(shop);
		URI shopUri=uriInfo.getAbsolutePathBuilder()
				.path(shop.getShop_ID().toString()).build();
		return Response.created(shopUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findShopById/{id}")
	public Response findShopById(@PathParam("id") Long id) {
		Shop shop=em.find(Shop.class, id);
		if(shop.equals(null))
			throw new NotFoundException();
		return Response.ok(shop).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllShops")
	public Response findAllShops() {
		TypedQuery<Shop> query=em.createNamedQuery("findAllShop", Shop.class);
		Shops shops=new Shops(query.getResultList());
		return Response.ok(shops).build();
	}
	
	@Path("/updateShop")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateShop(Shop shop) {
		if(shop.equals(null))
			throw new BadRequestException();
		em.merge(shop);
		return Response.ok(shop).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteShop/{id}")
	public Response deleteShop(@PathParam("id") Long id) {
		Shop shop=em.find(Shop.class, id);
		if(shop.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(shop));
		return Response.noContent().build();
	}

}
