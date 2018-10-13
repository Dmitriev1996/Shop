package ru.projects.Shop.rest;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
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

import ru.projects.Shop.ejb.CountryEJB;
import ru.projects.Shop.entity.Country;

@Path("/country")
@Stateless
public class CountryRestService {
	@Inject
	private CountryEJB countryEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createCountry")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createCountry(Country country) {
		if(country.equals(null))
			throw new BadRequestException();
		countryEJB.createCountry(country);
		URI countryUri=uriInfo.getAbsolutePathBuilder()
				.path(country.getCountry_ID().toString()).build();
		Response response=Response.created(countryUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findCountryById/{id}")
	public Response findCountryById(@PathParam("id") Long id) {
		Country country=countryEJB.findCountryById(id);
		if(country.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(country).build();
		return response;
	}
	
	@Path("/updateCountry")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateCountry(Country country) {
		if(country.equals(null))
			throw new BadRequestException();
		Country updated=countryEJB.updateCountry(country);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	

}
