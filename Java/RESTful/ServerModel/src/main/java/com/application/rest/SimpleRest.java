package com.application.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.application.bo.SimpleBO;
import com.application.model.ObjTeste;
import com.google.gson.Gson;
import com.sun.research.ws.wadl.Request;

@Path("/obj")
public class SimpleRest {
	private SimpleBO bo = new SimpleBO();
	Gson gson = new Gson();
	
	/**
	 * rest para obtencao de todos registros no database
	 * @param request
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllObj")
	public Response getAllObjTestes(String request) {	
		ObjTeste obj = gson.fromJson(request, ObjTeste.class);		
		return Response.status(200).entity(gson.toJson(bo.getAllObjTestes())).build();
	}
	
	/**
	 * rest para obtencao de  registros especificos no database
	 * @param request
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getObj")
	public Response getObjTesteById(String request) {	
		ObjTeste obj = gson.fromJson(request, ObjTeste.class);
		return Response.status(200).entity(gson.toJson(bo.getObjTesteById(obj))).build();
	}
	
	/**
	 * rest para exclusao de registros no database
	 * @param request
	 * @return
	 */
	@POST
	// aqui estou restringindo a usar apenas json, caso nao tivessse usado essa annotation
	//usaria todos os datatypes por default, o mesmo vale pro produces
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("deleteObj")
	public Response deleteObjTeste(String request) {	
		ObjTeste obj = gson.fromJson(request, ObjTeste.class);
		return Response.status(200).entity(gson.toJson(bo.deleteObjTeste(obj))).build();
	}
	
	/**
	 * rest para insercao de registros no database
	 * @param request
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("addObj")
	public Response addObjTeste(String request) {	
		ObjTeste obj = gson.fromJson(request, ObjTeste.class);
		return Response.status(200).entity(gson.toJson(bo.addObjTeste(obj))).build();
	}
	
	/**
	 * rest para ataulizacao de registros no database
	 * @param request
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("updateObj")
	public Response getMsg(String request) {	
		ObjTeste obj = gson.fromJson(request, ObjTeste.class);
		return Response.status(200).entity(gson.toJson(bo.updateObjTeste(obj))).build();
	}
}
