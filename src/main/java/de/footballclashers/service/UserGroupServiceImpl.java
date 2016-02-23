package de.footballclashers.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.GroupDetails;
import de.footballclashers.dao.interfaces.fbc.UserGroup;


@Component
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	private UserGroup usrGrp;

	public void doGroupCreation(GroupDetails group_details) {
		System.out.println("league id is"+group_details.getLeagueId());
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put("leagueId", group_details.getLeagueId());
		dataMap.put("groupName", group_details.getGroupName());
		dataMap.put("createdBy", group_details.getCreatedBy());
		dataMap.put("id",null);
		usrGrp.insert(dataMap);
		System.out.println("newly inserted values isss"+dataMap.get("id"));
	}

}
