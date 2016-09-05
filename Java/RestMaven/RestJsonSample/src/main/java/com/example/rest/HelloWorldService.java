package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/hello")
public class HelloWorldService {
	
	/**
	 * para Utilizar o gson no projeto, é necessario trazer o jar gson para dentro do projeto
	 * ou indicar a depencia, caso voce esteja usando maven, será dessa forma
	 * 
	 * <dependency>
	 *	    <groupId>com.google.code.gson</groupId>
	 *	    <artifactId>gson</artifactId>
	 *	    <version>2.2.4</version>
	 *	</dependency>
	 *
	 *apenas isso, lembrando que a versao pode mudar
	 */
	
	// aqui ta sendo usado por get
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		Gson gson = new Gson();
		ClassTest classTest = new ClassTest();
		classTest.setAge(1);
		classTest.setName(msg);	
		return Response.status(200).entity(gson.toJson(classTest)).build();

	}
}