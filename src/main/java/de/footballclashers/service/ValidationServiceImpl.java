package de.footballclashers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.exceptions.CurrentPasswordNotCorrect;
import de.footballclashers.exceptions.EmailAlreadyExistedException;
import de.footballclashers.exceptions.EmailNotExistedException;
import de.footballclashers.exceptions.LogInFailureException;
import de.footballclashers.exceptions.SocialIdNotPossibleToChangeException;
import de.footballclashers.manager.UsersManager;

@Component
public class ValidationServiceImpl implements ValidationService{

	@Autowired
	private UsersManager usersManager;
	public boolean validateUser(Users users) {
		return isEmailAlreadyExisted(users);
	}
	
	public boolean isEmailAlreadyExisted(Users usersDetails) throws EmailAlreadyExistedException{
		if(!usersManager.isEmailAlreadyExisted(usersDetails)) 
			throw new EmailAlreadyExistedException("exception.Email_Already_Existed",usersDetails.getEmail());
		return true;
	}
	
	public boolean isUserRegisteredWithSocialID(Users users) throws EmailNotExistedException,SocialIdNotPossibleToChangeException{
		Users user = usersManager.isUserRegisteredWithSocialID(users);
		if(user == null) throw new EmailNotExistedException("exception.Email_Not_Existed", users.getEmail());
		if(user.getSocial_id() != null) throw new SocialIdNotPossibleToChangeException("exception.socialID", "");
		return true;
	}

	public void isCurrentPasswordExisted(Users users){
		Users user = usersManager.isCurrentPasswordExisted(users);
		if(user == null) throw new EmailNotExistedException("exception.Email_Not_Existed", users.getEmail());
		if(user.getSocial_id() != null) throw new SocialIdNotPossibleToChangeException("exception.socialID", "");
		if(!user.getPassword().equalsIgnoreCase(users.getPassword())){
			throw new CurrentPasswordNotCorrect("exception.current", users.getPassword());
		}
	}

	public void isUSerAuth(Users usersDetails) {
		Users user = usersManager.isUSerAuth(usersDetails);
		if(user == null) throw new EmailNotExistedException("exception.Email_Not_Existed", usersDetails.getEmail());
		if(usersDetails.getPassword()!=null && !user.getPassword().equalsIgnoreCase(usersDetails.getPassword())){
			throw new LogInFailureException("exception.logIn", "");
		}else if(usersDetails.getSocial_id()!=null && !usersDetails.getSocial_id().equalsIgnoreCase(usersDetails.getSocial_id())){
			throw new LogInFailureException("exception.logIn", "");
		}
	}
	
}
