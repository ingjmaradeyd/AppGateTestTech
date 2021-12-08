package co.com.appgate.prueba.dao.impl;

import org.springframework.stereotype.Component;

import co.com.appgate.prueba.dao.LoginDAO;
import co.com.appgate.prueba.dto.UserDTO;

@Component
public class LoginDAOImpl implements LoginDAO{

	@Override
	public UserDTO getUser(String user) {
	   UserDTO userDto = new UserDTO();
	   userDto.setUser(user);
	   userDto.setPassword("123456789");
	   return userDto;
	}

}
