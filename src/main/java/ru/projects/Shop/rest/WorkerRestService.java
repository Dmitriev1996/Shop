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

import ru.projects.Shop.entity.Worker;
import ru.projects.Shop.entity.Workers;

@Path("/worker")
@Stateless
public class WorkerRestService {
	@Inject
	private EntityManager em;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createWorker")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createWorker(Worker worker) {
		if(worker.equals(null))
			throw new BadRequestException();
		em.persist(worker);
		URI workerUri=uriInfo.getAbsolutePathBuilder()
				.path(worker.getWorker_ID().toString()).build();
		return Response.created(workerUri).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findWorkerById/{id}")
	public Response findWorkerById(@PathParam("id") Long id) {
		Worker worker=em.find(Worker.class, id);
		if(worker.equals(null))
			throw new NotFoundException();
		return Response.ok(worker).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllWorkers")
	public Response findAllWorkers() {
		TypedQuery<Worker> query=em.createNamedQuery("findAllWorker", Worker.class);
		Workers workers=new Workers(query.getResultList());
		return Response.ok(workers).build();
	}
	
	@Path("/updateWorker")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateWorker(Worker worker) {
		if(worker.equals(null))
			throw new BadRequestException();
		em.merge(worker);
		return Response.ok(worker).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteWorker/{id}")
	public Response deleteWorker(@PathParam("id") Long id) {
		Worker worker=em.find(Worker.class, id);
		if(worker.equals(null))
			throw new NotFoundException();
		em.remove(em.merge(worker));
		return Response.noContent().build();
	}

}
