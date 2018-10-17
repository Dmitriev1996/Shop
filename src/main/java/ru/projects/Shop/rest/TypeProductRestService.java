package ru.projects.Shop.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import ru.projects.Shop.ejb.TypeProductEJB;
import ru.projects.Shop.entity.TypeProduct;

@Path("/typeProduct")
@Stateless
public class TypeProductRestService {
	@Inject
	private TypeProductEJB typeProductEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createTypeProduct")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createTypeProduct(TypeProduct typeProduct) {
		if(typeProduct.equals(null))
			throw new BadRequestException();
		typeProductEJB.createTypeProduct(typeProduct);
		URI typeProductUri=uriInfo.getAbsolutePathBuilder()
				.path(typeProduct.getTypeProduct_ID().toString()).build();
		Response response=Response.created(typeProductUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findTypeProductById/{id}")
	public Response findTypeProductById(@PathParam("id") Long id) {
		TypeProduct typeProduct=typeProductEJB.findTypeProductById(id);
		if(typeProduct.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(typeProduct).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllTypeProducts")
	public Response findAllTypeProducts() {
		Logger.getLogger(ClientRestService.class.getName()).log(Level.SEVERE, null, "Метод запроса вызван!");
		List<TypeProduct> typeProducts=typeProductEJB.findAllTypeProduct();
		Response response=Response.ok(typeProducts).build();
	    return response;
	}
	
	@Path("/updateTypeProduct")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateTypeProduct(TypeProduct typeProduct) {
		if(typeProduct.equals(null))
			throw new BadRequestException();
		TypeProduct updated=typeProductEJB.updateTypeProduct(typeProduct);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteTypeProduct")
	public Response deleteTypeProduct(TypeProduct typeProduct) {
		if(typeProduct.equals(null))
			throw new NotFoundException();
		typeProductEJB.deleteTypeProduct(typeProduct);
		Response response=Response.noContent().build();
		return response;
	}

}
