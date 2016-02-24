package de.footballclashers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.footballclashers.beans.GroupDetails;
import de.footballclashers.beans.Sucess;
import de.footballclashers.service.UserGroupServiceImpl;

@RestController
@RequestMapping("/GroupManagement")
public class UserGroupController {

	@Autowired
	public UserGroupServiceImpl userGrpSrvcImpl;
	
	@RequestMapping(value = "/group", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Sucess groupCreation(@RequestBody GroupDetails groupData) {
		int group_id = userGrpSrvcImpl.doGroupCreation(groupData);
		userGrpSrvcImpl.addUserToGroup(group_id, groupData.getCreatedBy());
		if(groupData.getUserIds().length > 0 ) {
			userGrpSrvcImpl.addInvitations(group_id, groupData.getUserIds());
		}
		Sucess success = new Sucess();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}

	@RequestMapping(value = "/group", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GroupDetails getGroupDetails() {
		return null;
	}

	@RequestMapping(value = "/addUserToGroup", method = RequestMethod.POST)
	public Sucess addUserToGroup(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "groupId") String groupId) {
		
		// check here whether league has been started or not.If not then only add user
		
		userGrpSrvcImpl.addInvitation(Integer.parseInt(groupId), Integer.parseInt(userId));
		Sucess success = new Sucess();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}

	@RequestMapping(value = "/AcceptingInvitation", method = RequestMethod.POST)
	public Sucess AcceptingInvitation(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "groupId") String groupId) {
		userGrpSrvcImpl.acceptInvitation(Integer.parseInt(groupId), Integer.parseInt(userId));
		Sucess success = new Sucess();
		success.setMessage("Success");
		success.setStatus(200);
		
		return success;
	}

	@RequestMapping(value = "/deleteUserFromGroup", method = RequestMethod.DELETE)
	public Sucess deleteUserFromGroup(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "groupId") String groupId) {
		return null;
	}
}
