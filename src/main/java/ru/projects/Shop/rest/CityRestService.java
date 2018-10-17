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

import ru.projects.Shop.ejb.CityEJB;
import ru.projects.Shop.entity.Cities;
import ru.projects.Shop.entity.City;

@Path("/city")
@Stateless
public class CityRestService {
	@Inject
	private CityEJB cityEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createCity")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createCity(City city) {
		if(city.equals(null))
			throw new BadRequestException();
		cityEJB.createCity(city);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(city.getCity_ID().toString()).build();
		Response response=Response.created(adressUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findCityById/{id}")
	public Response findCityById(@PathParam("id") Long id) {
		City city=cityEJB.findCityById(id);
		if(city.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(city).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllCities")
	public Response findAllCities() {
		List<City> cities=cityEJB.findAllCity();
		Response response=Response.ok(cities).build();
		return response;
	}
	
	@Path("/updateCity")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateCity(City city) {
		if(city.equals(null))
			throw new BadRequestException();
		City updated=cityEJB.updateCity(city);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteCity")
	public Response deleteCity(City city) {
		if(city.equals(null))
			throw new NotFoundException();
		cityEJB.deleteCity(city);
		Response response=Response.noContent().build();
		return response;
	}

}
