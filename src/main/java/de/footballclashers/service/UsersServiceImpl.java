package de.footballclashers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.UserGroupDetailsBean;
import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.manager.UsersManager;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersManager usersManager;
	@Autowired
	private ValidationService validationService;
	
	public void doUserRegistration(Users users) {
		boolean flag = validationService.validateUser(users);
		if(flag)
			usersManager.doUserRegistration(users);
	}
	
	public void doForGotPassword(String email){
		Users usersDetails = new Users();
		usersDetails.setEmail(email);
		boolean flag = validationService.isUserRegisteredWithSocialID(usersDetails);
		if(flag) usersManager.doForGotPassword(email);
	}
	
	public void doChangePassword(String email,String current,String newPassword){
		Users users = new Users();
		users.setPassword(current);
		users.setEmail(email);
		validationService.isCurrentPasswordExisted(users);
		usersManager.doChangePassword(email,current,newPassword);
	}
	
	public List<Users> getAllUser(){
		return usersManager.getAllUser();
	}
	
	public List<Users> getAllUser(String userName){
		Users usersDetails = new Users();
		usersDetails.setName(userName);
		return usersManager.getAllUser(usersDetails);
	}

	public void doLogIn(Users usersDetails) {
		validationService.isUSerAuth(usersDetails);
	}

	public List<UserGroupDetailsBean> getListOfInvitations(int user_id) {
		
		return usersManager.getListOfInvitations(user_id);
	}

	public Users getUserByEmail(Users user) {
		return usersManager.getUserByEmail(user);
	}

}
