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

import ru.projects.Shop.entity.TypeProduct;
import ru.projects.Shop.entity.TypeProducts;

@Path("/type_product")
@Stateless
public class TypeProductRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createPTypeProduct")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTypeProduct(TypeProduct typeProduct) {
		if(typeProduct.equals(null))
			throw new BadRequestException();
		em.persist(typeProduct);
		URI typeProductUri=uriInfo.getAbsolutePathBuilder()
				.path(typeProduct.getTypeProduct_ID().toString()).build();
		return Response.created(typeProductUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTypeProductById/{id}")
	public Response findTypeProductById(@PathParam("id") Long id) {
		TypeProduct typeProduct=em.find(TypeProduct.class, id);
		if(typeProduct.equals(null))
			throw new NotFoundException();
		return Response.ok(typeProduct).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTypeProducts")
	public Response findAllTypeProducts() {
		TypedQuery<TypeProduct> query=em.createNamedQuery("findAllTypeProduct", TypeProduct.class);
		TypeProducts typeProducts=new TypeProducts(query.getResultList());
		Response response=Response.ok(typeProducts).build();
		ArrayList<Object> list=new ArrayList<Object>();
	    list.add("*");
	    response.getHeaders().add("Access-Control-Allow-Origin", "*");
	    return response;
	}
	
	@Path("/updateTypeProduct")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateTypeProduct(TypeProduct typeProduct) {
		if(typeProduct.equals(null))
			throw new BadRequestException();
		em.merge(typeProduct);
		return Response.ok(typeProduct).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTypeProduct/{id}")
	public Response deleteTypeProduct(@PathParam("id") Long id) {
		TypeProduct typeProduct=em.find(TypeProduct.class, id);
		if(typeProduct.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(typeProduct));
		return Response.noContent().build();
	}

}
