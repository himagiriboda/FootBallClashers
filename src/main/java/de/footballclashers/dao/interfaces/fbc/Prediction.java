package de.footballclashers.dao.interfaces.fbc;

import org.apache.ibatis.annotations.Param;

public interface Prediction {
	public void insertGroupPrediction(@Param("group_member_id") int group_user_id,
			@Param("user_id") int user_id, 	@Param("match_id") int match_id, 
			@Param("TeamA_score") int A_score,@Param("TeamB_score") int B_score);
	
	public void insertChallengePrediction(@Param("challenge_id") int challenge_id,
			@Param("from_user_id") int user_id, @Param("match_id") int match_id, 
			@Param("TeamA_score") int A_score, @Param("TeamB_score") int B_score);
	
	public void insertSeasonalPrediction(@Param("from_user_id") int user_id, @Param("match_id") int match_id, 
			@Param("TeamA_score") int A_score, @Param("TeamB_score") int B_score);
}
