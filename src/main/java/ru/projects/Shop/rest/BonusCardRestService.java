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

import ru.projects.Shop.ejb.BonusCardEJB;
import ru.projects.Shop.entity.BonusCard;
import ru.projects.Shop.entity.BonusCards;

@Path("/bonusCard")
@Stateless
public class BonusCardRestService {
	@Inject
	private BonusCardEJB bonusCardEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createBonusCard")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createBonusCard(BonusCard bonuscard) {
		if(bonuscard.equals(null))
			throw new BadRequestException();
		bonusCardEJB.createBonusCard(bonuscard);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(bonuscard.getCard_ID().toString()).build();
		Response response=Response.created(adressUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findBonusCardById/{id}")
	public Response findBonusCardById(@PathParam("id") Long id) {
		BonusCard bonuscard=bonusCardEJB.findBonusCardById(id);
		if(bonuscard.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(bonuscard).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllBonusCards")
	public Response findAllBonusCards() {
		List<BonusCard> bonuscards=bonusCardEJB.findAllBonusCard();
		Response response=Response.ok(bonuscards).build();
		return response;
	}
	
	@Path("/updateBonusCard")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateBonusCard(BonusCard bonuscard) {
		if(bonuscard.equals(null))
			throw new BadRequestException();
		BonusCard updated=bonusCardEJB.updateBonusCard(bonuscard);
		Response response=Response.ok(bonuscard).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteBonusCard")
	public Response deleteBonusCard(BonusCard bonusCard) {
		bonusCardEJB.deleteBonusCard(bonusCard);
		Response response=Response.noContent().build();
		return response;
	}

}
