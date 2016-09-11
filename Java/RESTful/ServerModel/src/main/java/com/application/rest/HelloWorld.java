package com.application.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/hello")
public class HelloWorld {
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		Gson gson = new Gson();
		return Response.status(200).entity(gson.toJson(msg)).build();

	}
}
