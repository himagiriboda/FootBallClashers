package de.footballclashers.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.UserGroupDetailsBean;
import de.footballclashers.dao.interfaces.fbc.UserMapperBasicDAO;
import de.footballclashers.dao.model.fbc.Users;

@Component
public class UsersManagerImpl implements UsersManager{
	
	@Autowired
	private UserMapperBasicDAO userMapperBasicDAO;
	
	public void doUserRegistration(Users usersDetails) {
		userMapperBasicDAO.insert(usersDetails);
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
	
	public List<Users> getAllUser(Users usersDetails){
		return userMapperBasicDAO.getAllUserByName(usersDetails.getName());
	}
	
	public boolean isEmailAlreadyExisted(Users usersDetails){
		Users users = userMapperBasicDAO.getUserByEmail(usersDetails);
		if(users != null) 
			return false;
		return true;
	}
	
	public Users isUserRegisteredWithSocialID(Users usersDetails){
		return userMapperBasicDAO.getUserByEmail(usersDetails);
	}
	
	public Users isCurrentPasswordExisted(Users users){
		return userMapperBasicDAO.getUserByEmail(users);
	}
	
	public Users isUSerAuth(Users users){
		System.out.println("users"+users.getEmail());
		return userMapperBasicDAO.getUserByEmail(users);
	}
	
	public List<UserGroupDetailsBean> getListOfInvitations(int user_id) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// dataMap.put("email",email);
		return userMapperBasicDAO.getAllInvitations(user_id);
	}

	public Users getUserByEmail(Users users) {
		return userMapperBasicDAO.getUserByEmail(users);
	}
	
}
