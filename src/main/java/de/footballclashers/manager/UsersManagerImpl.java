package de.footballclashers.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.interfaces.fbc.UserMapperBasicDAO;
import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.exceptions.EmailAlreadyExistedException;

@Component
public class UsersManagerImpl implements UsersManager{
	
	@Autowired
	private UserMapperBasicDAO userMapperBasicDAO;
	
	public void doUserRegistration(UsersDetails usersDetails) {
		Users users = new Users();
		users.setEmail(usersDetails.getEmail());
		users.setName(usersDetails.getName());
		users.setPassword(usersDetails.getPassword());
		users.setSocial_id(usersDetails.getSocial_id());
		userMapperBasicDAO.insert(users);
	}
	
	public void doForGotPassword(String email){
		Users users = new Users();
		users.setEmail(email);
		users.setPassword("zcaSDgafg");
		userMapperBasicDAO.update(users);
	}
	
	public void doChangePassword(String email,String current,String newPassword){
		Users users = new Users();
		users.setEmail(email);
		users.setPassword(newPassword);
		userMapperBasicDAO.update(users);
	}
	
	public List<Users> getAllUser(){
		return userMapperBasicDAO.getAllUser();
	}
	
	public boolean isEmailAlreadyExisted(UsersDetails usersDetails){
		Users users = userMapperBasicDAO.getUserByEmail(usersDetails);
		if(users != null) 
			return true;
		return false;
	}
	
}
