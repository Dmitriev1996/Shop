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

import ru.projects.Shop.ejb.AdressEJB;
import ru.projects.Shop.entity.Adress;


@Path("/adress")
@Stateless
public class AdressRestService {
	@Inject
	private AdressEJB adressEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createAdress")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createAdress(Adress adress) {
		if(adress.equals(null))
			throw new BadRequestException();
		adressEJB.createAdress(adress);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(adress.getAdress_ID().toString()).build();
		Response response=Response.created(adressUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAdressById/{id}")
	public Response findAdressById(@PathParam("id") Long id) {
		Adress adress=adressEJB.findAdressById(id);
		if(adress.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(adress).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllAdresses")
	public Response findAllAdresses() {
		List<Adress> adresses=adressEJB.findAllAdress();
		Response response=Response.ok(adresses).build();
		return response;
	}
	
	@Path("/updateAdress")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateAdress(Adress adress) {
		if(adress.equals(null))
			throw new BadRequestException();
		Adress updated=adressEJB.updateAdress(adress);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteAdress")
	public Response deleteAdress(Adress adress) {
		adressEJB.deleteAdress(adress);
		Response response=Response.noContent().build();
		return response;
	}
	
	

}
