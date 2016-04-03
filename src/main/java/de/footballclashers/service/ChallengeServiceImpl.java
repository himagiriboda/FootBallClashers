package de.footballclashers.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	public void acceptChallenge(int id){
		challenge.update(id);
		
	}

}
