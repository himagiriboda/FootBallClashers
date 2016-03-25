package de.footballclashers.dao.interfaces.fbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.dao.model.fbc.Users;
public interface UserMapperBasicDAO {
	
	public void insert(Users usersDetails);
	
	public void update(Users usersDetails);
	
	public List<Users> getAllUser();
	
	public List<Users> getAllUserByName(String name);
	
	public Users getUserByEmail(Users usersDetails);
	
	public List<Users> getAllInvitations(@Param("user_id")int user_id);
	
	public List<MatchesDetails> findByListOfMatchesDetails(int group_id);
	
}
