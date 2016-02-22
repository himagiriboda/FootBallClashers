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
	
	public void doUserRegistration(UsersDetails usersDetails) {
		usersManager.doUserRegistration(usersDetails);
	}
	
	public void doForGotPassword(String email){
		usersManager.doForGotPassword(email);
	}
	
	public void doChangePassword(String email,String current,String newPassword){
		usersManager.doChangePassword(email,current,newPassword);
	}
	
	public List<Users> getAllUser(){
		return usersManager.getAllUser();
	}

}
