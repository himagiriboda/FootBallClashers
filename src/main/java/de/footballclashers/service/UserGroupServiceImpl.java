package de.footballclashers.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import de.footballclashers.beans.GroupChat;
import de.footballclashers.beans.GroupChatList;
import de.footballclashers.beans.GroupDetails;
import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.beans.Status;
import de.footballclashers.dao.interfaces.fbc.Prediction;
import de.footballclashers.dao.interfaces.fbc.UserGroup;
import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.manager.UserGroupManager;

@Component
public class UserGroupServiceImpl implements UserGroupService {
	private static Logger logger = LoggerFactory
			.getLogger(UserGroupServiceImpl.class);
	@Autowired
	private UserGroup usrGrp;
	
	@Autowired
	private UserGroupManager userGroupManager;

	@Autowired
	private Prediction prediction;
	
	public int doGroupCreation(GroupDetails group_details) {

		System.out.println("league id is" + group_details.getLeagueId());
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("leagueId", group_details.getLeagueId());
		dataMap.put("groupName", group_details.getGroupName());
		dataMap.put("createdBy", group_details.getCreatedBy());
		dataMap.put("id", null);
		usrGrp.insert(dataMap);
		Long group_id = (Long) dataMap.get("id");
		System.out.println("group id isss" + group_id);
		dataMap = null;
		return group_id.intValue();
	}

	public void addUserToGroup(int group_id, int user_id) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("group_id", group_id);
		dataMap.put("user_id", user_id);
		usrGrp.insert_groupMembers(dataMap);
		dataMap = null;
	}

	public void addInvitations(int group_id, String[] userIds) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		for (String user_id : userIds) {
			dataMap.put("group_id", group_id);
			dataMap.put("user_id", user_id);
			usrGrp.insertInvitations(dataMap);
			dataMap.clear();
		}
		dataMap = null;

	}

	public void addInvitation(int group_id, int user_id) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("group_id", group_id);
		dataMap.put("user_id", user_id);
		usrGrp.insertInvitations(dataMap);
		dataMap.clear();

		dataMap = null;

	}

	public void acceptInvitation(int group_id, int user_id) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("group_id", group_id);
		dataMap.put("user_id", user_id);
		usrGrp.deleteInvitationEntry(dataMap);
		usrGrp.insert_groupMembers(dataMap);
	}

	public List<GroupDetails> listOfGroupsCreatedByUser(String Email) {
		return userGroupManager.listOfGroupsCreatedByUser(Email);
	}

	public List<GroupDetails> listOfGroupsPartOfUser(String Email) {
		return userGroupManager.listOfGroupsPartOfUser(Email);
	}

	public void addGroupChat(GroupChat group_chat) {
		usrGrp.insertChat(group_chat);
	}

	public GroupChatList getGroupChatList(int group_id) {
		GroupChatList group_chatList = null;

		List<GroupChat> chatList = null;
		chatList = usrGrp.groupChatList(group_id);

		group_chatList = new GroupChatList();
		if (chatList != null) {
			group_chatList.setChatDetails(chatList);

			Status status = new Status();
			status.setCode("200");
			status.setMessage("Success");
			group_chatList.setStatus(status);
		} else {
			Status status = new Status();
			status.setCode("500");
			status.setMessage("Internal Server Error");
			group_chatList.setStatus(status);
		}
		return group_chatList;
	}

	public void deleteGroupUser(int group_id, int user_id) {
		usrGrp.deleteGroupUser(group_id, user_id);
	}
	
	public List<Users> findUsersByGroupID(int group_id){
		return userGroupManager.findUsersByGroupID(group_id);
	}

	public void dogroupMatchCreation(int group_id, int match_id) {
		userGroupManager.dogroupMatchCreation(group_id, match_id);
	}
	
	public List<MatchesDetails> findByListOfMatchesDetails(int group_id){
		return userGroupManager.findByListOfMatchesDetails(group_id);
	}

	public void setPrediction(int group_id, int user_id, int match_id,
			int TeamA_score, int TeamB_score) {
		int group_member_id=usrGrp.getGroupUserId(group_id, user_id);
		prediction.insertGroupPrediction(group_member_id,user_id, match_id, TeamA_score, TeamB_score);
		System.out.println("group user id is"+group_member_id);
	}
}
