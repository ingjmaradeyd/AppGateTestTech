package co.com.appgate.prueba.business;

import java.math.BigDecimal;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import co.com.appgate.prueba.bo.ErrorObject;
import co.com.appgate.prueba.bo.OperationObject;
import co.com.appgate.prueba.bo.ResponseObject;
import co.com.appgate.prueba.factory.DivisionImpl;
import co.com.appgate.prueba.factory.MultiplicationImpl;
import co.com.appgate.prueba.factory.PowImpl;
import co.com.appgate.prueba.factory.SubstractionImpl;
import co.com.appgate.prueba.factory.SumImpl;
import co.com.appgate.prueba.utils.Constants;

@Component
public class OperationBusinessImp implements OperationBusiness {
	
	@Autowired
	private SumImpl sumImpl;
	
	@Autowired
	private SubstractionImpl substractionImpl;
	
	@Autowired
	private MultiplicationImpl multiplicationImpl;
	
	@Autowired
	private DivisionImpl divisionImpl;
	
	@Autowired
	private PowImpl powImpl;

	@Override
	public ResponseObject doOperation(OperationObject operationObject) throws Exception {
		String operation = operationObject.getOperation().toUpperCase();
		ResponseObject response = new ResponseObject();
		Response result = Response.accepted().build();
		
		if (operation.equals(Constants.Operations.SUM)) {
			result = sumImpl.operate(operationObject);
		}

		if (operation.equals(Constants.Operations.SUBSTRACCION)) {
			result = substractionImpl.operate(operationObject);
		}

		if (operation.equals(Constants.Operations.MULTIPLICACTION)) {
			result = multiplicationImpl.operate(operationObject);
		}

		if (operation.equals(Constants.Operations.DIVISION)) {
			result = divisionImpl.operate(operationObject);
		}

		if (operation.equals(Constants.Operations.POWERING)) {
			result = powImpl.operate(operationObject);
		}
		
		if(result.getStatus() != HttpStatus.OK.value()) {
			ErrorObject error =result.readEntity(ErrorObject.class);
			response.setOperation(error.getReason());
		} else {
			BigDecimal valueOperation = result.readEntity(BigDecimal.class);
			response.setOperation(operation);
			response.setResponse(valueOperation);
		}
		
		return response;
	}

}
