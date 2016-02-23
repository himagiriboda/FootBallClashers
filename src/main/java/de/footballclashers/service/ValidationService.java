package de.footballclashers.service;

import de.footballclashers.beans.UsersDetails;

public interface ValidationService {
	public boolean validateUser(UsersDetails usersDetails);
	public boolean isEmailAlreadyExisted(UsersDetails usersDetails);
	public boolean isUserRegisteredWithSocialID(UsersDetails users);
	public void isCurrentPasswordExisted(UsersDetails users);
}
