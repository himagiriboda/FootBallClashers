package de.footballclashers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.footballclashers.beans.GroupChat;
import de.footballclashers.beans.GroupChatList;
import de.footballclashers.beans.GroupDetails;
import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.beans.Success;
import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.service.UserGroupService;

@RestController
@RequestMapping("/GroupManagement")
public class UserGroupController {

	@Autowired
	public UserGroupService userGrpSrvcImpl;

	@RequestMapping(value = "/group", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Success groupCreation(@RequestBody GroupDetails groupData) {
		int group_id = userGrpSrvcImpl.doGroupCreation(groupData);
		userGrpSrvcImpl.addUserToGroup(group_id, groupData.getCreatedBy());
		if (groupData.getUserIds().length > 0) {
			userGrpSrvcImpl.addInvitations(group_id, groupData.getUserIds());
		}
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}

	@RequestMapping(value = "/group", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GroupDetails getGroupDetails(
			@RequestParam(value = "email") String email) {
		return null;
	}

	@RequestMapping(value = "/listOfGroupsCreatedByUser", method = RequestMethod.GET)
	public List<GroupDetails> listOfGroupsCreatedByUser(
			@RequestParam(value = "email") String email) {
		return userGrpSrvcImpl.listOfGroupsCreatedByUser(email);
	}

	@RequestMapping(value = "/listOfGroupsPartOfUser", method = RequestMethod.GET)
	public List<GroupDetails> listOfGroupsPartOfUser(
			@RequestParam(value = "email") String email) {
		return userGrpSrvcImpl.listOfGroupsPartOfUser(email);
	}

	@RequestMapping(value = "/addUserToGroup", method = RequestMethod.POST)
	public Success addUserToGroup(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "groupId") String groupId) {

		// check here whether league has been started or not.If not then only
		// add user

		userGrpSrvcImpl.addInvitation(Integer.parseInt(groupId),
				Integer.parseInt(userId));
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}

	@RequestMapping(value = "/AcceptingInvitation", method = RequestMethod.POST)
	public Success AcceptingInvitation(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "groupId") String groupId) {
		userGrpSrvcImpl.acceptInvitation(Integer.parseInt(groupId),
				Integer.parseInt(userId));
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);

		return success;
	}

	@RequestMapping(value = "/deleteUserFromGroup", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Success deleteUserFromGroup(
			@RequestParam(value = "userId") int userId,
			@RequestParam(value = "groupId") int groupId) {
		userGrpSrvcImpl.deleteGroupUser(groupId, userId);

		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);

		return success;
	}

	@RequestMapping(value = "/addChat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Success addGroupChatMessage(@RequestBody GroupChat group_chat) {
		userGrpSrvcImpl.addGroupChat(group_chat);
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);

		return success;
	}

	@RequestMapping(value = "/ChatList", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public GroupChatList getGroupChatList(@RequestParam(value = "group_id") int group_id) {
		return userGrpSrvcImpl.getGroupChatList(group_id);
	}
	
	@RequestMapping(value = "/usersWithRanking", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Users> findUsersByGroupID(@RequestParam(value="group_id") int group_id){
		return userGrpSrvcImpl.findUsersByGroupID(group_id);
	}
	
	@RequestMapping(value="/groupMatch",method=RequestMethod.GET)
	public Success groupMatchCreation(@RequestParam(value="group_id") int group_id,@RequestParam(value="match_id") int match_id){
		userGrpSrvcImpl.dogroupMatchCreation(group_id, match_id);
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}
	
	@RequestMapping(value="/matchesDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MatchesDetails> findByListOfMatchesDetails(@RequestParam(value="group_id") int group_id){
		return userGrpSrvcImpl.findByListOfMatchesDetails(group_id);
		
	}
	
	@RequestMapping(value="/groupPrediction", produces= MediaType.APPLICATION_JSON_VALUE)
	public Success ScorePrediction(@RequestParam("group_id") int group_id, @RequestParam("user_id") int user_id,
			@RequestParam("match_id") int match_id, @RequestParam("TeamA_score") int A_score,
			@RequestParam("TeamB_score") int B_score) {
		userGrpSrvcImpl.setPrediction(group_id, user_id, match_id, A_score, B_score);
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}
	
	
}
