package de.footballclashers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.footballclashers.beans.LeagueDetails;
import de.footballclashers.service.ChallengeServiceImpl;

@RestController
@RequestMapping("/leagueManagement")
public class LeagueController {

	@Autowired
	private ChallengeServiceImpl challengeServiceImpl;
	@RequestMapping(value="/featureLeagues",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public LeagueDetails  findByFeatureLeagueMatchDetails(){
		
		return challengeServiceImpl.findByLeagueDetails();
		
	
	}
}
