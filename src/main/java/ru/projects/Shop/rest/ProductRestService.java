package ru.projects.Shop.rest;

import java.net.URI;
import java.util.ArrayList;

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

import ru.projects.Shop.SpecialResponse;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.Products;

@Path("/product")
@Stateless
public class ProductRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createProduct")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createProduct(Product product) {
		if(product.equals(null))
			throw new BadRequestException();
		em.persist(product);
		URI productUri=uriInfo.getAbsolutePathBuilder()
				.path(product.getProduct_ID().toString()).build();
		return Response.created(productUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findProductById/{id}")
	public Response findProductById(@PathParam("id") Long id) {
		Product product=em.find(Product.class, id);
		if(product.equals(null))
			throw new NotFoundException();
		Response response=SpecialResponse.createResponse(product);
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllProducts")
	public Response findAllProducts() {
		TypedQuery<Product> query=em.createNamedQuery("findAllProduct", Product.class);
	    Products products=new Products(query.getResultList());
		//return Response.ok(products).header("Access-Control-Allow-Origin", "*").build();
	    Response response=Response.ok(products).build();
	    ArrayList<Object> list=new ArrayList<Object>();
	    list.add("*");
	    response.getHeaders().add("Access-Control-Allow-Origin", "*");
	    return response;
	}
	
	@Path("/updateProduct")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateProduct(Product product) {
		if(product.equals(null))
			throw new BadRequestException();
		em.merge(product);
		return Response.ok(product).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteProduct/{id}")
	public Response deleteProduct(@PathParam("id") Long id) {
		Product product=em.find(Product.class, id);
		if(product.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(product));
		return Response.noContent().build();
	}

}
