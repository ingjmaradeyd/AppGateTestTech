package co.com.appgate.prueba.servicelogin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.appgate.prueba.dao.LoginDAO;
import co.com.appgate.prueba.dto.UserDTO;
import co.com.appgate.prueba.servicelogin.LoginUser;

@Service
public class LoginUserImpl implements LoginUser {

	@Autowired
	private LoginDAO loginDao;

	@Override
	public boolean isUserValid(UserDTO user) {
		boolean isValid = false;
		UserDTO userRegistred = loginDao.getUser(user.getUser());
		isValid = (userRegistred.getUser().equals(user.getUser())
				&& userRegistred.getPassword().equals(user.getPassword())) && userRegistred != null ? true : false;
		return isValid;
	}

}
