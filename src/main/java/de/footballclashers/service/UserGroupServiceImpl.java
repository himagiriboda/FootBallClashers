package de.footballclashers.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.GroupDetails;
import de.footballclashers.dao.interfaces.fbc.UserGroup;

@Component
public class UserGroupServiceImpl implements UserGroupService {
	private static Logger logger = LoggerFactory
			.getLogger(UserGroupServiceImpl.class);
	@Autowired
	private UserGroup usrGrp;

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

}
