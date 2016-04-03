package de.footballclashers.service;

import java.util.List;

public interface ChallengeService {

	public void setChallengePrediction(int match_id,int from_user_id, int to_user_id,
			int TeamA_score, int TeamB_score);
	
	public void setSeasonalChallengePrediction(int match_id,int from_user_id,
			int TeamA_score, int TeamB_score);
	
	public List<de.footballclashers.beans.Challenge> findByListOfChallenges(Integer user_id);
}
