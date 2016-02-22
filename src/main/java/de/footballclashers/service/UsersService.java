package de.footballclashers.service;

import java.util.List;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.model.fbc.Users;

public interface UsersService {
	public void doUserRegistration(UsersDetails usersDetails);
	public void doForGotPassword(String email);
	public void doChangePassword(String email,String current,String newPassword);
	public List<Users> getAllUser();
}
