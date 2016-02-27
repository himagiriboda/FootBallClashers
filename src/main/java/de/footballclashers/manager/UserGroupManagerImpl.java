package de.footballclashers.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.GroupDetails;
import de.footballclashers.dao.interfaces.fbc.UserGroup;

@Component
public class UserGroupManagerImpl implements UserGroupManager{
	@Autowired
	private UserGroup userGroup;
	public List<GroupDetails> listOfGroupsCreatedByUser(String email){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("email",email);
		return userGroup.listOfGroupsCreatedByUser(dataMap);
	}
	public List<GroupDetails> listOfGroupsPartOfUser(String email){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("email",email);
		return userGroup.listOfGroupsCreatedByUser(dataMap);
	}
}
