package de.footballclashers.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.footballclashers.beans.LeagueDetails;
import de.footballclashers.beans.MatchesDetails;

@RestController
@RequestMapping("/leagueManagement")
public class LeagueController {

	@RequestMapping(value="/featureLeagues",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<LeagueDetails> findByFeatureLeagueMatchDetails(){
		List<LeagueDetails> list = new ArrayList<LeagueDetails>();
		LeagueDetails leagueDetails = new LeagueDetails();
		leagueDetails.setName("Foot");
		leagueDetails.setStartTime(new Date());
		leagueDetails.setEndTime(new Date());
		leagueDetails.setStatus(Byte.valueOf((byte)0));
		MatchesDetails matchesDetails = new MatchesDetails();
		matchesDetails.setLeagueId(1);
		matchesDetails.setMatchTime(new Date());
		matchesDetails.setTeamA(1);
		matchesDetails.setTeamB(2);
		matchesDetails.setTeamBScore(0);
		leagueDetails.setMatchesDetails(matchesDetails);
		list.add(leagueDetails);
		return list;
	}
}
