package de.footballclashers.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.footballclashers.beans.Success;
import de.footballclashers.service.ChallengeServiceImpl;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

	@Autowired
	private ChallengeServiceImpl challengeService;
	
	@RequestMapping(value="/prediction", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Success setPrediction(@RequestParam("match_id") int match_id,
			@RequestParam("from_user_id") int from_user_id, @Param("to_user_id") int to_user_id,
			@RequestParam("TeamA_score") int A_score, @RequestParam("TeamB_score") int B_score) {
	
		challengeService.setChallengePrediction(match_id, from_user_id, to_user_id, A_score, B_score);
		
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}
	
	@RequestMapping(value="/seasonalprediction", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Success setSeasonalPrediction(@RequestParam("match_id") int match_id,
			@RequestParam("from_user_id") int from_user_id, 
			@RequestParam("TeamA_score") int A_score,  @RequestParam("TeamB_score") int B_score) {
	
		challengeService.setSeasonalChallengePrediction(match_id, from_user_id,  A_score, B_score);
		
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}
}
