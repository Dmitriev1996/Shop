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

import ru.projects.Shop.ejb.ProductUnitEJB;
import ru.projects.Shop.entity.ProductUnit;

@Path("/productUnit")
@Stateless
public class ProductUnitRestService {
	@Inject
	private ProductUnitEJB productUnitEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createProductUnit")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createProductUnit(ProductUnit productUnit) {
		if(productUnit.equals(null))
			throw new BadRequestException();
		productUnitEJB.createProductUnit(productUnit);
		URI productUri=uriInfo.getAbsolutePathBuilder()
				.path(productUnit.getProductUnit_ID().toString()).build();
		Response response=Response.created(productUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findProductUnitById/{id}")
	public Response findProductUnitById(@PathParam("id") Long id) {
		ProductUnit productUnit=productUnitEJB.findProductUnitById(id);
		if(productUnit.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(productUnit).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllProductUnits")
	public Response findAllProductUnits() {
		List<ProductUnit> productUnits=productUnitEJB.findAllProductUnits();
		Response response=Response.ok(productUnits).build();
		return response;
	}
	
	@Path("/updateProductUnit")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateProductUnit(ProductUnit productUnit) {
		if(productUnit.equals(null))
			throw new BadRequestException();
	    ProductUnit updated=productUnitEJB.updateProductUnit(productUnit);
	    Response response=Response.ok(productUnit).build();
	    return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteProductUnit")
	public Response deleteProductUnit(ProductUnit productUnit) {
		if(productUnit.equals(null))
			throw new NotFoundException();
		productUnitEJB.deleteProductUnit(productUnit);
		Response response=Response.noContent().build();
		return response;
	}

}
