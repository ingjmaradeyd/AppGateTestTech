package co.com.appgate.prueba.serviceoperation;


import co.com.appgate.prueba.dto.OperationDTO;
import co.com.appgate.prueba.dto.ResponseObject;

public interface OperationCalculator {

	public ResponseObject operate(OperationDTO operator);
	
}
