package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

public class Status implements Serializable {
	private int StatusCode;
	private String ClientError;
	private List<ServerError> ServerErrorList;
	private String Token;
	private String Role;
	
	public Status() {}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public String getClientError() {
		return ClientError;
	}

	public void setClientError(String clientError) {
		ClientError = clientError;
	}

	public List<ServerError> getServerErrorList() {
		return ServerErrorList;
	}
	
	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public void setServerErrorList(List<ServerError> serverErrorList) {
		ServerErrorList = serverErrorList;
	}
	
	
	
	

}
