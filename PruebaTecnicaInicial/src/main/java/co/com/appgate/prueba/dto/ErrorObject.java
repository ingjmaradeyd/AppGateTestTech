package co.com.appgate.prueba.dto;

import java.io.Serializable;

public class ErrorObject implements Serializable {

	private static final long serialVersionUID = -8684743495054694894L;
	private Integer code;
	private String reason;
	
	public ErrorObject(Integer code, String reason) {
		this.code = code;
		this.reason = reason;
	}
	
	public ErrorObject() {
		
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
