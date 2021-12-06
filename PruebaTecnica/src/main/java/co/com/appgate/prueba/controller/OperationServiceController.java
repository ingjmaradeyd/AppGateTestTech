package co.com.appgate.prueba.controller;

import co.com.appgate.prueba.bo.OperationObject;
import co.com.appgate.prueba.business.OperationBusiness;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Path("/technical/test")
public class OperationServiceController {

	@Autowired
	private OperationBusiness operationBusiness;
	
	
	@POST
	@Path("/operate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response doOperation(@RequestBody OperationObject operationObject) throws Exception {
		ResponseBuilder response = Response.ok(operationBusiness.doOperation(operationObject));
		return response.build();
	}

}
