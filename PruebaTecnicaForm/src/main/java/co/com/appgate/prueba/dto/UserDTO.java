package co.com.appgate.prueba.dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty
	private String user;
	
	@NotEmpty
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
