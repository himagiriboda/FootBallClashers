package de.footballclashers.dao.interfaces.fbc;

import java.util.List;

import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.model.fbc.Users;
public interface UserMapperBasicDAO {
	public void insert(Users usersDetails);
	public void update(Users usersDetails);
	public List<Users> getAllUser();
	public Users getUserByEmail(UsersDetails usersDetails);
}
