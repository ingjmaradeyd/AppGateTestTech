package co.com.appgate.prueba.bo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResponseObject implements Serializable {

	private static final long serialVersionUID = 6710372407514166003L;
	private String operation;
	private BigDecimal response;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public BigDecimal getResponse() {
		return response;
	}

	public void setResponse(BigDecimal response) {
		this.response = response;
	}

}
