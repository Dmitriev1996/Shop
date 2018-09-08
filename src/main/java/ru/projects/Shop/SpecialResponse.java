package ru.projects.Shop;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

public class SpecialResponse { 
	public static Response createResponse(Object obj) {
		Response response=Response.ok(obj).build();
		ArrayList<Object> list=new ArrayList<Object>();
		list=new ArrayList<Object>();
		list.add("*");
	    response.getHeaders().add("Access-Control-Allow-Origin", "*");
	    return response;
	}

}
