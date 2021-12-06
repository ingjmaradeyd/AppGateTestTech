package co.com.appgate.prueba.jersey;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import co.com.appgate.prueba.controller.SubstractionOperationController;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
	
	@PostConstruct
	public void init() {
		register(SubstractionOperationController.class);
	}

}
