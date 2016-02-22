package de.footballclashers.service;

import de.footballclashers.beans.UsersDetails;

public interface ValidationService {
	public boolean validateEmployee(UsersDetails usersDetails);
	public boolean isEmailAlreadyExisted(UsersDetails usersDetails);
}
