package de.footballclashers.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class MatchesDetails {
	
	private Integer leagueId;
	private Integer matchId;
	private String leagueName;
	private Integer teamA;
	private String teamAName;
	private Integer teamB;
	private String teamBName;
	private Integer teamAScore;
	private Integer teamBScore;
	private Date matchTime;
	private Integer groupID;
	private String groupName;
	
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
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamAName() {
		return teamAName;
	}
	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}
	public String getTeamBName() {
		return teamBName;
	}
	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}
	public Integer getGroupID() {
		return groupID;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	
	

}
