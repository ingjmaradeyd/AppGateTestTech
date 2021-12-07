package co.com.appgate.prueba.domain;

import co.com.appgate.prueba.dto.UserDTO;

public interface LoginValidation {

	public boolean isValidLogin(UserDTO userDto);
	
}
