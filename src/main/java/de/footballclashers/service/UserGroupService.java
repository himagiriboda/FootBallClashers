package de.footballclashers.service;

import java.util.List;

import de.footballclashers.beans.GroupDetails;

public interface UserGroupService {
	public int doGroupCreation(GroupDetails group_details);
	public void addUserToGroup(int group_id,int user_id);
	public void addInvitations(int group_id,String[] userIds);
	public void addInvitation(int group_id,int userId);
	public void acceptInvitation(int group_id, int user_id);
	public List<GroupDetails> listOfGroupsCreatedByUser(String Email);
	public List<GroupDetails> listOfGroupsPartOfUser(String Email);
}
