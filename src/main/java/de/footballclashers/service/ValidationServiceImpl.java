package de.footballclashers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.exceptions.EmailAlreadyExistedException;
import de.footballclashers.exceptions.EmailNotExistedException;
import de.footballclashers.exceptions.SocialIdNotPossibleToChangeException;
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
	
	public boolean isUserRegisteredWithSocialID(UsersDetails users) throws EmailNotExistedException,SocialIdNotPossibleToChangeException{
		Users user = usersManager.isUserRegisteredWithSocialID(users);
		if(user == null) throw new EmailNotExistedException("exception.Email_Not_Existed", users.getEmail());
		if(user.getSocial_id() != null) throw new SocialIdNotPossibleToChangeException("exception.socialID", "");
		return true;
	}

}
