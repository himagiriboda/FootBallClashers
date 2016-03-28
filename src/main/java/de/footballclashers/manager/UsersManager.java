package de.footballclashers.manager;

import java.util.List;

import de.footballclashers.beans.UserGroupDetailsBean;
import de.footballclashers.dao.model.fbc.Users;

public interface UsersManager {
	public void doUserRegistration(Users users);
	public void doForGotPassword(String email);
	public void doChangePassword(String email,String current,String newPassword);
	public List<Users> getAllUser();
	public boolean isEmailAlreadyExisted(Users users);
	public Users isUserRegisteredWithSocialID(Users users);
	public Users isCurrentPasswordExisted(Users users);
	public Users isUSerAuth(Users users);
	public List<Users> getAllUser(Users users);
	public List<UserGroupDetailsBean> getListOfInvitations(int user_id);
	public Users getUserByEmail(Users users);
}
