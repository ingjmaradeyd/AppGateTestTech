package co.com.appgate.prueba.domain.impl;

import org.springframework.stereotype.Component;

import co.com.appgate.prueba.domain.LoginValidation;
import co.com.appgate.prueba.dto.UserDTO;

@Component
public class LoginValidationImpl implements LoginValidation {

	@Override
	public boolean isValidLogin(UserDTO userDto) {
		return false;
	}

}
