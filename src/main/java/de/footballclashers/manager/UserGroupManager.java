package de.footballclashers.manager;

import java.util.List;

import de.footballclashers.beans.GroupDetails;
import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.dao.model.fbc.Users;

public interface UserGroupManager {
	public List<GroupDetails> listOfGroupsCreatedByUser(String email);
	public List<GroupDetails> listOfGroupsPartOfUser(String Email);
	public List<Users> findUsersByGroupID(int group_id);
	public void dogroupMatchCreation(int group_id, int match_id);
	public List<MatchesDetails> findByListOfMatchesDetails(int group_id);
	public List<MatchesDetails> findByListOfMatchesDetails();
}
