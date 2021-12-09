package co.com.appgate.prueba.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.appgate.prueba.dto.UserDTO;
import co.com.appgate.prueba.jwt.JWTToken;
import co.com.appgate.prueba.servicelogin.LoginUser;

@Controller
@Path("/init")
public class LoginController {

	@Autowired
	private JWTToken jwtToken;
	
	@Autowired
	private LoginUser loginUser;

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@RequestBody UserDTO userDto) throws Exception {
		if (loginUser.isUserValid(userDto)) {
			String token = jwtToken.getJWTToken(userDto.getUser());
			return Response.ok().header("Authorization", token).build();
		} else {
			return Response.serverError().status(Status.UNAUTHORIZED).build();
		}

	}
	
	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout() {
		return Response.ok().header("Authorization", null).build();
	}
	
	

}
