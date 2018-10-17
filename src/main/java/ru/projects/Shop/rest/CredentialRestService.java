package ru.projects.Shop.rest;

import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.projects.Shop.ejb.ClientEJB;
import ru.projects.Shop.ejb.CredentialEJB;
import ru.projects.Shop.ejb.TokenEJB;
import ru.projects.Shop.entity.Credential;
import ru.projects.Shop.entity.ServerError;
import ru.projects.Shop.entity.Status;
import ru.projects.Shop.entity.Token;

@Path("/auth")
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
	
	private ObjectMapper mapper=new ObjectMapper();
	
	@Path("/Registration")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
		return response;
	}
	
	@Path("/login")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response Authorisation(String json) {
		Status status=new Status();
		String clientError="";
		int countError=0;
		ServerError serverError;
		ArrayList<ServerError> serverErrorList=new ArrayList<ServerError>();
		Response response;
		Token token=null;
			try {
				Credential credential;
			    credential = mapper.readValue(json, Credential.class);
				Credential check=null;
				try {
				   check=credentialEJB.checkUser(credential);
				} catch (Exception e) {
					countError++;
					clientError="Неверный логин или пароль!";
					serverError=new ServerError();
					serverError.setException(e.getCause().toString());
					serverError.setMessage(e.getMessage());
					serverErrorList.add(serverError);
				}
				if(check!=null) {
					token=tokenEJB.createToken(check);
					status.setToken(token.getToken());
					status.setRole(token.getCredential().getRole());
				}
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					countError++;
					e.printStackTrace();
					clientError="На сервере произошла ошибка, обратитесь к разработчикам!";
					serverError=new ServerError();
					serverError.setException(e.getCause().toString());
					serverError.setMessage(e.getMessage());
					serverErrorList.add(serverError);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					countError++;
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					countError++;
					e.printStackTrace();
			} finally {
				status.setServerErrorList(serverErrorList);
				status.setClientError(clientError);
				if(countError==0) {
					status.setStatusCode(200);
					response=Response.ok(status).build();
					if(token!=null) {
						response.getHeaders().add("Token", token.getToken());
						response.getHeaders().add("Role", token.getCredential().getRole());
					}
				} else {
					status.setStatusCode(400);
					response=Response.ok(status).build();
				}
				return response;
			}
			
	
		
	}
	
	@Path("/Auth")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
		return response;
	}
	
	@Path("/Exit")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response Exit(String value) {
		Response response;
		Token token=tokenEJB.findTokenByValue(value);
		tokenEJB.deleteToken(token);
		response=Response.ok().build();
		return response;
	}

}
