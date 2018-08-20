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

import ru.projects.Shop.entity.TypeShop;
import ru.projects.Shop.entity.TypeShops;

@Path("/type_shop")
@Stateless
public class TypeShopRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createTypePShop")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTypeShop(TypeShop typeShop) {
		if(typeShop.equals(null))
			throw new BadRequestException();
		em.persist(typeShop);
		URI typeShopUri=uriInfo.getAbsolutePathBuilder()
				.path(typeShop.getTypeShop_ID().toString()).build();
		return Response.created(typeShopUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTypeShopById/{id}")
	public Response findTypeShopById(@PathParam("id") Long id) {
		TypeShop typeShop=em.find(TypeShop.class, id);
		if(typeShop.equals(null))
			throw new NotFoundException();
		return Response.ok(typeShop).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTypeShops")
	public Response findAllTypeShops() {
		TypedQuery<TypeShop> query=em.createNamedQuery("findAllTypeShop", TypeShop.class);
		TypeShops typeShops=new TypeShops(query.getResultList());
		return Response.ok(typeShops).build();
	}
	
	@Path("/updateTypeShop")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateTypeShop(TypeShop typeShop) {
		if(typeShop.equals(null))
			throw new BadRequestException();
		em.merge(typeShop);
		return Response.ok(typeShop).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTypeShop/{id}")
	public Response deleteTypeShop(@PathParam("id") Long id) {
		TypeShop typeShop=em.find(TypeShop.class, id);
		if(typeShop.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(typeShop));
		return Response.noContent().build();
	}

}
