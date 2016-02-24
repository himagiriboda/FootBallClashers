package de.footballclashers.beans;

import java.util.ArrayList;
import java.util.List;

public class FeatureLeagueMatchDetails {
	
	private List<LeagueDetails> featureLeagueMatchDetails = new ArrayList<LeagueDetails>();

	public List<LeagueDetails> getFeatureLeagueMatchDetails() {
		return featureLeagueMatchDetails;
	}

	public void setFeatureLeagueMatchDetails(
			List<LeagueDetails> featureLeagueMatchDetails) {
		this.featureLeagueMatchDetails = featureLeagueMatchDetails;
	}
	
	
}
