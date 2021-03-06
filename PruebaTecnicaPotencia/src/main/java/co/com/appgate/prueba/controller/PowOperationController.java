package co.com.appgate.prueba.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.appgate.prueba.pojo.PowObject;

@Controller
@Path("/powservice")
public class PowOperationController {
	
	@POST
	@Path("/powoperation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response sumOperation(@RequestBody PowObject powObject) {
		ResponseBuilder responseBuilder = Response.ok(powObject.getNumber1().pow(powObject.getNumber2().intValue()));
		return responseBuilder.build();
	}

}
