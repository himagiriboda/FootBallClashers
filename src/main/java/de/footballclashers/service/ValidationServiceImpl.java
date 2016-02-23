package de.footballclashers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.exceptions.EmailAlreadyExistedException;
import de.footballclashers.manager.UsersManager;

@Component
public class ValidationServiceImpl implements ValidationService{

	@Autowired
	private UsersManager usersManager;
	public boolean validateUser(UsersDetails usersDetails) {
		return isEmailAlreadyExisted(usersDetails);
	}
	
	public boolean isEmailAlreadyExisted(UsersDetails usersDetails) throws EmailAlreadyExistedException{
		if(!usersManager.isEmailAlreadyExisted(usersDetails)) 
			throw new EmailAlreadyExistedException("exception.Email_Already_Existed",usersDetails.getEmail());
		return false;
	}
	
	public boolean isUserRegisteredWithSocialID(UsersDetails users){
		boolean flag = usersManager.isUserRegisteredWithSocialID(users);
		return flag;
	}

}
