package co.com.appgate.prueba.dao;

import co.com.appgate.prueba.dto.UserDTO;

public interface LoginDAO {
	
	public UserDTO getUser(String user);

}
