package de.footballclashers.dao.interfaces.fbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import de.footballclashers.beans.GroupChat;
import de.footballclashers.beans.GroupDetails;
import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.beans.TeamDetails;
import de.footballclashers.dao.model.fbc.Users;

public interface UserGroup {

	public int insert(Map<String, Object> dataMap);

	public void insert_groupMembers(Map<String, Object> dataMap);

	public void insertInvitations(Map<String, Object> dataMap);

	public void deleteInvitationEntry(Map<String, Object> dataMap);
	
	public List<GroupDetails> listOfGroupsCreatedByUser(Map<String, Object> dataMap);
	
	public List<GroupDetails> listOfGroupsPartOfUser(Map<String, Object> dataMap);
	
	public void insertChat(GroupChat group_chat);

	public List<GroupChat> groupChatList(int group_id);
	
	public void deleteGroupUser(@Param("group_id") int group_id, @Param("user_id") int user_id);
	
	public int getGroupUserId(@Param("group_id") int group_id, @Param("user_id") int user_id);
	
	public List<Users> getUsersByGroupID(@Param("group_id") int group_id);
	
	public void dogroupMatchCreation(@Param("user_group_id") int group_id, @Param("match_id") int user_id);
	
	public List<MatchesDetails> findByListOfMatchesDetails(@Param("group_id") int group_id);
	
	public List<MatchesDetails> findByListOfAllMatchesDetails();
	
	public List<TeamDetails> findMatchDetilsByIDs(@Param("teamA") int teamA,@Param("teamB") int teamB);
}
