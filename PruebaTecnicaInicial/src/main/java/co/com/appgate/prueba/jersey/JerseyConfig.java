package co.com.appgate.prueba.jersey;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import co.com.appgate.prueba.controller.LoginController;
import co.com.appgate.prueba.controller.OperationController;
import co.com.appgate.prueba.filter.AuthenticatorFilter;



@Component
@ApplicationPath("/*")
public class JerseyConfig extends ResourceConfig {
	
	@PostConstruct
	public void init() {
		register(LoginController.class);
		register(OperationController.class);
		register(AuthenticatorFilter.class);
	}

}
