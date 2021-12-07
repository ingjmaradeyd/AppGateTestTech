package co.com.appgate.prueba.factory.interfaces;


import javax.ws.rs.core.Response;

import co.com.appgate.prueba.bo.OperationObject;


public interface MathOperation {

	public Response operate(OperationObject operationObject) throws Exception;
	
}
