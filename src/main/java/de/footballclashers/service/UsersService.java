package de.footballclashers.service;

import java.util.List;

import de.footballclashers.beans.UserGroupDetailsBean;
import de.footballclashers.dao.model.fbc.Users;

public interface UsersService {
	public void doUserRegistration(Users users);
	public void doForGotPassword(String email);
	public void doChangePassword(String email,String current,String newPassword);
	public List<Users> getAllUser();
	public void doLogIn(Users usersDetails);
	public List<Users> getAllUser(String userName);
	public List<UserGroupDetailsBean> getListOfInvitations(int user_id);
	public Users getUserByEmail(Users user);
}
