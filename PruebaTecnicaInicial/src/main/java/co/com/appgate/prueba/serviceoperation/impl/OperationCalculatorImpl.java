package co.com.appgate.prueba.serviceoperation.impl;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;


import co.com.appgate.prueba.dto.OperationDTO;

import co.com.appgate.prueba.dto.ResponseObject;
import co.com.appgate.prueba.serviceoperation.OperationCalculator;
import co.com.appgate.prueba.util.Constants;

@Service
public class OperationCalculatorImpl implements OperationCalculator {

	private static final String port = "8082";
	private static final String operation = "/technical/test/operate";

	@Override
	public ResponseObject operate(OperationDTO operator) {
		ResponseObject responseObj = new ResponseObject();
		Response response = callServiceOperator(operator);
		responseObj = response.readEntity(ResponseObject.class);
		return responseObj;
	}

	private Response callServiceOperator(OperationDTO operator) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(operator);
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(Constants.ServiceCall.PATH + port + operation);
		Builder builder = webTarget.request();
		return builder.post(Entity.json(jsonString));
	}

}
