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
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Clients;

@Path("/client")
@Stateless
public class ClientRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createClient")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createClient(Client client) {
		if(client.equals(null))
			throw new BadRequestException();
		em.persist(client);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(client.getClient_ID().toString()).build();
		return Response.created(adressUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findClientById/{id}")
	public Response findClientById(@PathParam("id") Long id) {
		Client client=em.find(Client.class, id);
		if(client.equals(null))
			throw new NotFoundException();
		return Response.ok(client).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllClients")
	public Response findAllClients() {
		TypedQuery<Client> query=em.createNamedQuery("findAllClient", Client.class);
		Clients clients=new Clients(query.getResultList());
		return Response.ok(clients).build();
	}
	
	@Path("/updateClient")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateClient(Client client) {
		if(client.equals(null))
			throw new BadRequestException();
		em.merge(client);
		return Response.ok(client).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteClient/{id}")
	public Response deleteClient(@PathParam("id") Long id) {
		Client client=em.find(Client.class, id);
		if(client.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(client));
		return Response.noContent().build();
	}

}
