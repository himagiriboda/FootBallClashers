package de.footballclashers.manager;

import java.util.List;

import de.footballclashers.beans.GroupDetails;

public interface UserGroupManager {
	public List<GroupDetails> listOfGroupsCreatedByUser(String email);
	public List<GroupDetails> listOfGroupsPartOfUser(String Email);
}
