package co.com.appgate.prueba.business;

import co.com.appgate.prueba.bo.OperationObject;
import co.com.appgate.prueba.bo.ResponseObject;

public interface OperationBusiness {

	public ResponseObject doOperation(OperationObject operationObject) throws Exception;
	
}
