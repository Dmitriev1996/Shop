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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ru.projects.Shop.TokenFactory;
import ru.projects.Shop.ejb.ClientEJB;
import ru.projects.Shop.ejb.CredentialEJB;
import ru.projects.Shop.ejb.TokenEJB;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Credential;
import ru.projects.Shop.entity.Token;

@Path("/Credential")
@Stateless
public class CredentialRestService {
	@Inject
	private CredentialEJB credentialEJB;
	@Inject
	private TokenEJB tokenEJB;
	@Inject
	private ClientEJB clientEJB;
	@Context
	private UriInfo uriInfo;
	@Context
	private HttpHeaders httpHeaders;
	
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
	    response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@Path("/Login")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response Authorisation(Credential credential) {
		Token token;
		Response response;
		if(credential.equals(null))
			throw new BadRequestException();
		String login=credential.getLogin();
		String password=credential.getPassword();
		boolean check=credentialEJB.checkUser(credential);
		if(check==true) {
			token=TokenFactory.createToken(credential);
			response=Response.ok().build();
			response.getHeaders().add("Token", token.getToken());
			response.getHeaders().add("Role", token.getCredential().getRole());
		} else {
			response=Response.ok().build();
		}
	    response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@Path("/Auth")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response Authentication(String value) {
		boolean auth=false;
		Response response;
		if(value.equals(null)) {
			throw new BadRequestException();
		}
		Token token=tokenEJB.findTokenByValue(value);
		if(token!=null) {
			auth=true;
		}
		response=Response.ok().build();
		response.getHeaders().add("Authenticated", auth);
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}
	
	@Path("/Exit")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response Exit(String value) {
		Response response;
		Token token=tokenEJB.findTokenByValue(value);
		tokenEJB.deleteToken(token);
		response=Response.ok().build();
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		return response;
	}

}
