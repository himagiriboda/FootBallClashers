package de.footballclashers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.manager.UsersManager;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersManager usersManager;
	@Autowired
	private ValidationService validationService;
	
	public void doUserRegistration(UsersDetails usersDetails) {
		boolean flag = validationService.validateUser(usersDetails);
		if(flag)
			usersManager.doUserRegistration(usersDetails);
	}
	
	public void doForGotPassword(String email){
		UsersDetails usersDetails = new UsersDetails();
		usersDetails.setEmail(email);
		boolean flag = validationService.isUserRegisteredWithSocialID(usersDetails);
		if(flag) usersManager.doForGotPassword(email);
	}
	
	public void doChangePassword(String email,String current,String newPassword){
		UsersDetails users = new UsersDetails();
		users.setPassword(current);
		users.setEmail(email);
		validationService.isCurrentPasswordExisted(users);
		usersManager.doChangePassword(email,current,newPassword);
	}
	
	public List<Users> getAllUser(){
		return usersManager.getAllUser();
	}

	public void doLogIn(UsersDetails usersDetails) {
		validationService.isUSerAuth(usersDetails);
	}

}
