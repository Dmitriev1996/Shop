package ru.projects.Shop.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

import ru.projects.Shop.SpecialResponse;
import ru.projects.Shop.ejb.ProductEJB;
import ru.projects.Shop.entity.Product;

@Path("/product")
@Stateless
public class ProductRestService {
	@Inject
	private ProductEJB productEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createProduct")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createProduct(Product product) {
		if(product.equals(null))
			throw new BadRequestException();
		productEJB.createProduct(product);
		URI productUri=uriInfo.getAbsolutePathBuilder()
				.path(product.getProduct_ID().toString()).build();
		Response response=Response.created(productUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findProductById/{id}")
	public Response findProductById(@PathParam("id") Long id) {
		Product product=productEJB.findProductById(id);
		if(product.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(product).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllProducts")
	public Response findAllProducts() {
	    List<Product> products=productEJB.findAllProduct();
	    Response response=Response.ok(products).build();
	    return response;
	}
	
	@Path("/updateProduct")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateProduct(Product product) {
		if(product.equals(null))
			throw new BadRequestException();
		Product updated=productEJB.updateProduct(product);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteProduct")
	public Response deleteProduct(Product product) {
		if(product.equals(null))
			throw new NotFoundException();
		productEJB.deleteProduct(product);
		Response response=Response.noContent().build();
		return response;
	}

}
