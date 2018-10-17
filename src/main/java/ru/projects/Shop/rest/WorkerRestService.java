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

import ru.projects.Shop.ejb.WorkerEJB;
import ru.projects.Shop.entity.Worker;
import ru.projects.Shop.entity.Workers;

@Path("/worker")
@Stateless
public class WorkerRestService {
	@Inject
	private WorkerEJB workerEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/createWorker")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createWorker(Worker worker) {
		if(worker.equals(null))
			throw new BadRequestException();
		workerEJB.createWorker(worker);
		URI workerUri=uriInfo.getAbsolutePathBuilder()
				.path(worker.getWorker_ID().toString()).build();
		Response response=Response.created(workerUri).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findWorkerById/{id}")
	public Response findWorkerById(@PathParam("id") Long id) {
		Worker worker=workerEJB.findWorkerById(id);
		if(worker.equals(null))
			throw new NotFoundException();
		Response response=Response.ok(worker).build();
		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/findAllWorkers")
	public Response findAllWorkers() {
		List<Worker> workers=workerEJB.findAllWorker();
		Response response=Response.ok(workers).build();
		return response;
	}
	
	@Path("/updateWorker")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateWorker(Worker worker) {
		if(worker.equals(null))
			throw new BadRequestException();
		Worker updated=workerEJB.updateWorker(worker);
		Response response=Response.ok(updated).build();
		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/deleteWorker")
	public Response deleteWorker(Worker worker) {
		if(worker.equals(null))
			throw new NotFoundException();
		workerEJB.deleteWorker(worker);
		Response response=Response.noContent().build();
		return response;
	}

}
