package de.footballclashers.dao.interfaces.fbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.beans.TeamDetails;

public interface Challenge {
	
	public int setChallenge(Map<String,Object> challengeMap);
	public List<de.footballclashers.beans.Challenge> findByListOfChallenges(@Param("user_id") int user_id);
	public void update(@Param("id") int id);
	public List<TeamDetails> findByTeamDetails();
	public List<MatchesDetails> findByMatchesDetails();
	
}
