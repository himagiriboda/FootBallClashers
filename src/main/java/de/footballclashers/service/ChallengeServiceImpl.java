package de.footballclashers.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.footballclashers.beans.LeagueDetails;
import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.beans.TeamDetails;
import de.footballclashers.dao.interfaces.fbc.Challenge;
import de.footballclashers.dao.interfaces.fbc.Prediction;

@Component
public class ChallengeServiceImpl implements ChallengeService {


	@Autowired
	private Challenge challenge;
	
	@Autowired
	private Prediction prediction;
	
	public void setChallengePrediction( int match_id, int from_user_id, int to_user_id,
			int A_score, int B_score) {
		Map<String,Object> challengeMap = new HashMap<String, Object>();
		challengeMap.put("match_id", match_id);
		challengeMap.put("from_user_id", from_user_id);
		challengeMap.put("to_user_id", to_user_id);
		challengeMap.put("id", null);
		challenge.setChallenge(challengeMap);
		
		Long challenge_id = (Long) challengeMap.get("id");
		int chal_id = challenge_id.intValue();
		
		prediction.insertChallengePrediction(chal_id, from_user_id, match_id, A_score, B_score);
		System.out.println("challenge id is"+chal_id);
	}

	public void setSeasonalChallengePrediction(int match_id, int from_user_id,
			int TeamA_score, int TeamB_score) {

		prediction.insertSeasonalPrediction(from_user_id, match_id, TeamA_score, TeamB_score);
		
	}
	
	public List<de.footballclashers.beans.Challenge> findByListOfChallenges(Integer user_id){
		
		return challenge.findByListOfChallenges(user_id);
		
	}
	
	public List<de.footballclashers.beans.Challenge> findByListOfChallengesPartOfUser(Integer user_id){
		
		return challenge.findByListOfChallengesPartOfUser(user_id);
		
	}
	
	
	public void acceptChallenge(int id){
		challenge.update(id);
		
	}
	
	public HashMap<Integer,TeamDetails> findByTeamDetails(){
		List<TeamDetails> teamData = challenge.findByTeamDetails();
		HashMap<Integer,TeamDetails> map = new HashMap<Integer,TeamDetails>();
		if(teamData != null && !teamData.isEmpty()){
			for(Iterator<TeamDetails> it = teamData.iterator() ; it.hasNext() ;){
				TeamDetails teamDetails = it.next();
				map.put(teamDetails.getId(), teamDetails);
			}
		}
		return map;
	}
	
    public LeagueDetails findByLeagueDetails(){
    	
    	LeagueDetails l = new LeagueDetails();
    	HashMap<Integer,TeamDetails> map = findByTeamDetails();
    	List<MatchesDetails> matchesDetails = challenge.findByMatchesDetails();
    	if(matchesDetails != null && !matchesDetails.isEmpty()){
    		for(Iterator<MatchesDetails> it = matchesDetails.iterator() ; it.hasNext();){
    			MatchesDetails matchesDetails2 = it.next();
    			TeamDetails teamA = map.get(matchesDetails2.getTeamA());
    			matchesDetails2.setTeamAName(teamA.getName());
    			TeamDetails teamB = map.get(matchesDetails2.getTeamB());
    			matchesDetails2.setTeamBName(teamB.getName());
    			l.getMatchesDetails().add(matchesDetails2);
    		}
    	}
    	return l;
    }
}
