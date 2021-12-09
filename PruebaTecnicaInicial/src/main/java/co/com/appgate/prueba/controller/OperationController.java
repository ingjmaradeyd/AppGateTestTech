package co.com.appgate.prueba.controller;



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

import co.com.appgate.prueba.dto.OperationDTO;
import co.com.appgate.prueba.serviceoperation.OperationCalculator;

@Controller
@Path("/calculator")
public class OperationController {

	@Autowired
	private OperationCalculator calculator;
	
	
	@POST
	@Path("/operations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response doOperation(@RequestBody OperationDTO operation) {
		ResponseBuilder response = Response.ok(calculator.operate(operation));
		return response.build();
	}
	
}
