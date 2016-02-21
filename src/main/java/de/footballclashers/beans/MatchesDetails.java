package de.footballclashers.beans;

import java.util.Date;

public class MatchesDetails {
	
	private Integer leagueId;
	private Integer teamA;
	private Integer teamB;
	private Integer teamAScore;
	private Integer teamBScore;
	private Date matchTime;
	
	public Integer getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}
	public Integer getTeamA() {
		return teamA;
	}
	public void setTeamA(Integer teamA) {
		this.teamA = teamA;
	}
	public Integer getTeamB() {
		return teamB;
	}
	public void setTeamB(Integer teamB) {
		this.teamB = teamB;
	}
	public Integer getTeamAScore() {
		return teamAScore;
	}
	public void setTeamAScore(Integer teamAScore) {
		this.teamAScore = teamAScore;
	}
	public Integer getTeamBScore() {
		return teamBScore;
	}
	public void setTeamBScore(Integer teamBScore) {
		this.teamBScore = teamBScore;
	}
	public Date getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}
	
	

}
