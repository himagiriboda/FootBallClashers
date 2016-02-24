package de.footballclashers.dao.interfaces.fbc;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserGroup {

	public int insert(Map<String, Object> dataMap);

	public void insert_groupMembers(Map<String, Object> dataMap);

	public void insertInvitations(Map<String, Object> dataMap);

	public void deleteInvitationEntry(Map<String, Object> dataMap);
}
