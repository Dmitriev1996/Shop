package ru.projects.Shop.entity;

import java.io.Serializable;

public class ServerError implements Serializable {
	private String Exception;
	private String Message;
	
	public ServerError() {}

	public String getException() {
		return Exception;
	}

	public void setException(String exception) {
		Exception = exception;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

}
