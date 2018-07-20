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

import ru.projects.Shop.entity.Cities;
import ru.projects.Shop.entity.City;

@Path("city")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class CityRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@POST
	public Response createCity(City city) {
		if(city.equals(null))
			throw new BadRequestException();
		em.persist(city);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(city.getCity_ID().toString()).build();
		return Response.created(adressUri).build();
	}
	
	@GET
	@Path("{id}")
	public Response findCityById(@PathParam("id") Long id) {
		City city=em.find(City.class, id);
		if(city.equals(null))
			throw new NotFoundException();
		return Response.ok(city).build();
	}
	
	@GET
	public Response findAllCities() {
		TypedQuery<City> query=em.createNamedQuery("findAllCity", City.class);
		Cities cities=new Cities(query.getResultList());
		return Response.ok(cities).build();
	}
	
	@POST
	public Response updateCity(City city) {
		if(city.equals(null))
			throw new BadRequestException();
		em.merge(city);
		return Response.ok(city).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCity(@PathParam("id") Long id) {
		City city=em.find(City.class, id);
		if(city.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(city));
		return Response.noContent().build();
	}

}
