package ru.projects.Shop.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;
import java.util.logging.Level;

@Provider
@PreMatching
public class RESTRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestCtx) throws IOException {
		if(requestCtx.getRequest().getMethod().equals("OPTIONS")) {
			Response response=Response.status(Response.Status.OK).build();
			requestCtx.abortWith(response);
		}
		
	}

}
