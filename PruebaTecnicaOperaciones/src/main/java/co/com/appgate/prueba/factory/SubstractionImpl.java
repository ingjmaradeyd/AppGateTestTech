package co.com.appgate.prueba.factory;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import co.com.appgate.prueba.bo.OperationObject;
import co.com.appgate.prueba.bo.RequestObject;
import co.com.appgate.prueba.factory.interfaces.MathOperation;
import co.com.appgate.prueba.utils.Constants;

@Component
public class SubstractionImpl implements MathOperation{
	
	
	private static final String port = "8091";
	private static final String operation = "/subservice/substractionoperation";

	private Response callServiceSubstraction(BigDecimal number1, BigDecimal number2) {
		RequestObject subObject = new RequestObject();
		subObject.setNumber1(number1);
		subObject.setNumber2(number2);
		Gson gson = new Gson();
		String jsonString = gson.toJson(subObject);
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(Constants.ServicesData.BASE_URL + port + operation);
		Builder builder = webTarget.request();
		return builder.post(Entity.json(jsonString));
	}

	@Override
	public Response operate(OperationObject operationObject) {
		return callServiceSubstraction(operationObject.getNumber1(), operationObject.getNumber2());
	}

}
