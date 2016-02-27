package de.footballclashers.dao.interfaces.fbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import de.footballclashers.beans.GroupDetails;

public interface UserGroup {

	public int insert(Map<String, Object> dataMap);

	public void insert_groupMembers(Map<String, Object> dataMap);

	public void insertInvitations(Map<String, Object> dataMap);

	public void deleteInvitationEntry(Map<String, Object> dataMap);
	
	public List<GroupDetails> listOfGroupsCreatedByUser(Map<String, Object> dataMap);
	
	public List<GroupDetails> listOfGroupsPartOfUser(Map<String, Object> dataMap);

}
