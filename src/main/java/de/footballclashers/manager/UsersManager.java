package de.footballclashers.manager;

import java.util.List;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.model.fbc.Users;

public interface UsersManager {
	public void doUserRegistration(UsersDetails usersDetails);
	public void doForGotPassword(String email);
	public void doChangePassword(String email,String current,String newPassword);
	public List<Users> getAllUser();
	public boolean isEmailAlreadyExisted(UsersDetails usersDetails);
	public Users isUserRegisteredWithSocialID(UsersDetails usersDetails);
}
