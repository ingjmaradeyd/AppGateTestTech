package co.com.appgate.prueba.controller;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.appgate.prueba.pojo.DivObject;
import co.com.appgate.prueba.pojo.ErrorObject;

@Controller
@Path("/divservice")
public class DivisionOperationController {

	@POST
	@Path("/divisionoperation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response sumOperation(@RequestBody DivObject divObject) {
		if (divObject.getNumber2().equals(BigDecimal.ZERO)) {
			ErrorObject error = new ErrorObject();
			error.setCode(HttpStatus.NOT_ACCEPTABLE.value());
			error.setReason("Divide by zero");
			return  Response.status(HttpStatus.NOT_ACCEPTABLE.value())
			        .entity(error).build();
			
		} else {
			try {
				return Response.ok(divObject.getNumber1().divide(divObject.getNumber2())).build();
			} catch (Exception ex) {
				ErrorObject error = new ErrorObject();
				error.setCode(HttpStatus.NOT_ACCEPTABLE.value());
				error.setReason(ex.getMessage());
				return Response.status(HttpStatus.NOT_ACCEPTABLE.value())
				        .entity(error).build();
			}
		}
	}

}
