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
import ru.projects.Shop.entity.Adresses;


@Path("/adress")
@Stateless
public class AdressRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createAdress")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createAdress(Adress adress) {
		if(adress.equals(null))
			throw new BadRequestException();
		em.persist(adress);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(adress.getAdress_ID().toString()).build();
		return Response.created(adressUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAdressById/{id}")
	public Response findAdressById(@PathParam("id") Long id) {
		Adress adress=em.find(Adress.class, id);
		if(adress.equals(null))
			throw new NotFoundException();
		return Response.ok(adress).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllAdresses")
	public Response getAdresses() {
		TypedQuery<Adress> query=em.createNamedQuery("findAllAdress", Adress.class);
		Adresses adresses=new Adresses(query.getResultList());
		return Response.ok(adresses).build();
	}
	
	@Path("/updateAdress")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateAdress(Adress adress) {
		if(adress.equals(null))
			throw new BadRequestException();
		em.merge(adress);
		return Response.ok(adress).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteAdress/{id}")
	public Response deleteAdress(@PathParam("id") Long id) {
		Adress adress=em.find(Adress.class, id);
		if(adress.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(adress));
		return Response.noContent().build();
	}
	
	

}
