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
import ru.projects.Shop.entity.BonusCard;
import ru.projects.Shop.entity.BonusCards;

@Path("/bonuscard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class BonusCardRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@POST
	public Response createBonusCard(BonusCard bonuscard) {
		if(bonuscard.equals(null))
			throw new BadRequestException();
		em.persist(bonuscard);
		URI adressUri=uriInfo.getAbsolutePathBuilder()
				.path(bonuscard.getCard_ID().toString()).build();
		return Response.created(adressUri).build();
	}
	
	@GET
	@Path("{id}")
	public Response findBonusCardById(@PathParam("id") Long id) {
		BonusCard bonuscard=em.find(BonusCard.class, id);
		if(bonuscard.equals(null))
			throw new NotFoundException();
		return Response.ok(bonuscard).build();
	}
	
	@GET
	public Response findAllBonusCards() {
		TypedQuery<BonusCard> query=em.createNamedQuery("findAllBonusCard", BonusCard.class);
		BonusCards bonuscards=new BonusCards(query.getResultList());
		return Response.ok(bonuscards).build();
	}
	
	@POST
	public Response updateBonusCard(BonusCard bonuscard) {
		if(bonuscard.equals(null))
			throw new BadRequestException();
		em.merge(bonuscard);
		return Response.ok(bonuscard).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteBonusCard(@PathParam("id") Long id) {
		BonusCard bonuscard=em.find(BonusCard.class, id);
		if(bonuscard.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(bonuscard));
		return Response.noContent().build();
	}

}
