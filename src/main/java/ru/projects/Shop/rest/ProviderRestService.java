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

import ru.projects.Shop.ejb.ProviderEJB;
import ru.projects.Shop.entity.Provider;
import ru.projects.Shop.entity.Providers;

@Path("/provider")
@Stateless
public class ProviderRestService {
	@Inject
	private ProviderEJB providerEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createProvider")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createProvider(Provider provider) {
		if(provider.equals(null))
			throw new BadRequestException();
		providerEJB.createProvider(provider);
		URI providerUri=uriInfo.getAbsolutePathBuilder()
				.path(provider.getProvider_ID().toString()).build();
		Response response=Response.created(providerUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findProviderById/{id}")
	public Response findProviderById(@PathParam("id") Long id) {
		Provider provider=providerEJB.findProviderById(id);
		if(provider.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(provider).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllProviders")
	public Response findAllProviders() {
		List<Provider> providers=providerEJB.findAllProvider();
		Response response=Response.ok(providers).build();
		return response;
	}
	
	@Path("/updateProvider")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateProvider(Provider provider) {
		if(provider.equals(null))
			throw new BadRequestException();
		Provider updated=providerEJB.updateProvider(provider);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteProvider")
	public Response deleteProvider(Provider provider) {
		if(provider.equals(null))
			throw new NotFoundException();
		providerEJB.deleteProvider(provider);
		Response response=Response.noContent().build();
		return response;
	}

}
