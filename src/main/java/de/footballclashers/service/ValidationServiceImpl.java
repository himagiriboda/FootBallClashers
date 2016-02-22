package de.footballclashers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.manager.UsersManager;

@Component
public class ValidationServiceImpl implements ValidationService{

	@Autowired
	private UsersManager usersManager;
	public boolean validateEmployee(UsersDetails usersDetails) {
		return isEmailAlreadyExisted(usersDetails);
	}
	
	public boolean isEmailAlreadyExisted(UsersDetails usersDetails){
		return usersManager.isEmailAlreadyExisted(usersDetails);
	}

}
