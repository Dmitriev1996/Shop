package ru.projects.Shop.rest;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ru.projects.Shop.ejb.CredentialEJB;
import ru.projects.Shop.entity.Credential;

@Path("/Credential")
@Stateless
public class CredentialRestService {
	@Inject
	private CredentialEJB credentialEJB;
	@Context
	private UriInfo uriInfo;
	
	@Path("/Registration")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response Registration(Credential credential) {
		String message="";
		if(credential.equals(null))
			throw new BadRequestException();
		Credential obj=credentialEJB.createCredential(credential);
		if(obj!=null) {
			message="Регистрация прошла успешно!";
		} else {
			message="Ошибка!";
		}
		Response response=Response.ok(message).build();
		ArrayList<Object> list=new ArrayList<Object>();
	    list.add("*");
	    response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	public Response Authorisation(Credential credential) {
		if(credential.equals(null))
			throw new BadRequestException();
		String login=credential.getLogin();
		String password=credential.getPassword();
		return null;
	}

}
