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
import de.footballclashers.beans.UsersDetails;
import de.footballclashers.service.UserGroupServiceImpl;

@RestController
@RequestMapping("/GroupManagement")
public class UserGroupController {
	
	/* @Autowired
	public UserGroupServiceImpl userGrp; */
	
	@RequestMapping(value="/group",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void groupCreation(@RequestBody GroupDetails groupData){
		//userGrp.doGroupCreation(groupData);
	}
	
	@RequestMapping(value="/group", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public GroupDetails getGroupDetails(){
		return null;
	}
	
	@RequestMapping(value="/addUserToGroup",method=RequestMethod.POST)
	public Sucess addUserToGroup(@RequestParam(value="userId") String userId,@RequestParam(value="groupId") String groupId){
		return null;
	}
	
	@RequestMapping(value="/AcceptingInvitation",method=RequestMethod.POST)
	public Sucess AcceptingInvitation(@RequestParam(value="userId") String userId,@RequestParam(value="groupId") String groupId){
		return null;
	}
	
	@RequestMapping(value="/deleteUserFromGroup",method=RequestMethod.DELETE)
	public Sucess deleteUserFromGroup(@RequestParam(value="userId") String userId,@RequestParam(value="groupId") String groupId){
		return null;
	}
}
