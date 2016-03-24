package de.footballclashers.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.GroupDetails;
import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.beans.TeamDetails;
import de.footballclashers.dao.interfaces.fbc.UserGroup;
import de.footballclashers.dao.model.fbc.Users;

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
		// return userGroup.listOfGroupsCreatedByUser(dataMap);
		return userGroup.listOfGroupsPartOfUser(dataMap);
	}
	
	public List<Users> findUsersByGroupID(int group_id){
		return userGroup.getUsersByGroupID(group_id);
	}
	
    public void dogroupMatchCreation(int user_group_id, int match_id) {
    	 userGroup.dogroupMatchCreation(user_group_id, match_id);
	}
    public List<MatchesDetails> findByListOfMatchesDetails(int group_id){
    	List<MatchesDetails> list = userGroup.findByListOfMatchesDetails(group_id);
    	if(list != null && !list.isEmpty()){
    		for(Iterator<MatchesDetails> it = list.iterator();it.hasNext();){
    			MatchesDetails matchesDetails = it.next();
    			if(matchesDetails != null){
    				List<TeamDetails> data = userGroup.findMatchDetilsByIDs(matchesDetails.getTeamA(), matchesDetails.getTeamB());
    				if(data != null && !data.isEmpty()){
    					for(Iterator<TeamDetails> its = data.iterator() ; its.hasNext() ;){
    						TeamDetails teamDetails = its.next();
    						if(teamDetails != null){
    							if(teamDetails.getId() == matchesDetails.getTeamA()){
    								matchesDetails.setTeamAName(teamDetails.getName());
    							}else if(teamDetails.getId() == matchesDetails.getTeamB()){
    								matchesDetails.setTeamBName(teamDetails.getName());
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	return list;
    }
}
