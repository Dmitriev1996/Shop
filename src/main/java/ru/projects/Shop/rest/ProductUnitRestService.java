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

import ru.projects.Shop.entity.ProductUnit;
import ru.projects.Shop.entity.ProductUnits;

@Path("/product_unit")
@Stateless
public class ProductUnitRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createProductUnit")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createProductUnit(ProductUnit productUnit) {
		if(productUnit.equals(null))
			throw new BadRequestException();
		em.persist(productUnit);
		URI productUri=uriInfo.getAbsolutePathBuilder()
				.path(productUnit.getProductUnit_ID().toString()).build();
		return Response.created(productUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findProductUnitById/{id}")
	public Response findProductUnitById(@PathParam("id") Long id) {
		ProductUnit productUnit=em.find(ProductUnit.class, id);
		if(productUnit.equals(null))
			throw new NotFoundException();
		return Response.ok(productUnit).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllProductUnits")
	public Response findAllProductUnits() {
		TypedQuery<ProductUnit> query=em.createNamedQuery("findAllProductUnit", ProductUnit.class);
		ProductUnits productUnits=new ProductUnits(query.getResultList());
		return Response.ok(productUnits).build();
	}
	
	@Path("/updateProductUnit")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateProductUnit(ProductUnit productUnit) {
		if(productUnit.equals(null))
			throw new BadRequestException();
		em.merge(productUnit);
		return Response.ok(productUnit).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteProductUnit/{id}")
	public Response deleteProductUnit(@PathParam("id") Long id) {
		ProductUnit productUnit=em.find(ProductUnit.class, id);
		if(productUnit.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(productUnit));
		return Response.noContent().build();
	}

}
