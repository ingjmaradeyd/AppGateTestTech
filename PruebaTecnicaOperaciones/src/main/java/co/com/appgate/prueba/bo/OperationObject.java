package co.com.appgate.prueba.bo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OperationObject implements Serializable {

	private static final long serialVersionUID = 7696270341815511660L; /// generated serial

	private BigDecimal number1;
	private BigDecimal number2;
	private String operation;

	public BigDecimal getNumber1() {
		return number1;
	}

	public void setNumber1(BigDecimal number1) {
		this.number1 = number1;
	}

	public BigDecimal getNumber2() {
		return number2;
	}

	public void setNumber2(BigDecimal number2) {
		this.number2 = number2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
