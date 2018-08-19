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

import ru.projects.Shop.entity.Provider;
import ru.projects.Shop.entity.Providers;

@Path("/provider")
@Stateless
public class ProviderRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createProvider")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createProvider(Provider provider) {
		if(provider.equals(null))
			throw new BadRequestException();
		em.persist(provider);
		URI providerUri=uriInfo.getAbsolutePathBuilder()
				.path(provider.getProvider_ID().toString()).build();
		return Response.created(providerUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findProviderById/{id}")
	public Response findProviderById(@PathParam("id") Long id) {
		Provider provider=em.find(Provider.class, id);
		if(provider.equals(null))
			throw new NotFoundException();
		return Response.ok(provider).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllProviders")
	public Response findAllProviders() {
		TypedQuery<Provider> query=em.createNamedQuery("findAllProvider", Provider.class);
		Providers providers=new Providers(query.getResultList());
		return Response.ok(providers).build();
	}
	
	@Path("/updateProvider")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateProvider(Provider provider) {
		if(provider.equals(null))
			throw new BadRequestException();
		em.merge(provider);
		return Response.ok(provider).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteProvider/{id}")
	public Response deleteProvider(@PathParam("id") Long id) {
		Provider provider=em.find(Provider.class, id);
		if(provider.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(provider));
		return Response.noContent().build();
	}

}
