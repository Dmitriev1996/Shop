package ru.projects.Shop.rest;

import java.io.IOException;
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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.projects.Shop.ejb.ClientEJB;
import ru.projects.Shop.entity.Client;

@Path("/client")
@Stateless
public class ClientRestService {
	@Inject
	private ClientEJB clientEJB;
	@Context
	private UriInfo uriInfo;
	@Context
	private HttpHeaders headers;
	
	private ObjectMapper mapper=new ObjectMapper();
	
	@Path("/createClient")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createClient(String json) {
			try {
				Client client = mapper.readValue(json, Client.class);
				clientEJB.createClient(client);
				URI adressUri=uriInfo.getAbsolutePathBuilder()
						.path(client.getSurname()).build();
				Response response=Response.created(adressUri).build();
				return response;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BadRequestException();
			}
		
		
	}
	
	@Path("/findClientByToken")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response findClientByToken(String value) {
		Client client;
		if(value.equals(null)) {
			throw new BadRequestException();
		}
		client=clientEJB.findClientByToken(value);
		Response response=Response.ok(client).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findClientById/{id}")
	public Response findClientById(@PathParam("id") Long id) {
		Client client=clientEJB.findClientById(id);
		if(client.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(client).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllClients")
	public Response findAllClients() {
		List<Client> clients=clientEJB.findAllClient();
		Response response=Response.ok(clients).build();
		return response;
	}
	
	@Path("/updateClient")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateClient(Client client) {
		if(client.equals(null))
			throw new BadRequestException();
		Client updated=clientEJB.updateClient(client);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteClient")
	public Response deleteClient(Client client) {
		if(client.equals(null))
			throw new NotFoundException();
		clientEJB.deleteClient(client);
		Response response=Response.noContent().build();
		return response;
	}
}
