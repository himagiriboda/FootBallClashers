package de.footballclashers.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Challenge {
	
	private Integer id;
	private Integer match_id;
	private Integer from_user_id;
	private Integer to_user_id;
	private Integer A_score;
	private Integer B_score;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMatch_id() {
		return match_id;
	}
	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
	}
	public Integer getFrom_user_id() {
		return from_user_id;
	}
	public void setFrom_user_id(Integer from_user_id) {
		this.from_user_id = from_user_id;
	}
	public Integer getTo_user_id() {
		return to_user_id;
	}
	public void setTo_user_id(Integer to_user_id) {
		this.to_user_id = to_user_id;
	}
	public Integer getA_score() {
		return A_score;
	}
	public void setA_score(Integer a_score) {
		A_score = a_score;
	}
	public Integer getB_score() {
		return B_score;
	}
	public void setB_score(Integer b_score) {
		B_score = b_score;
	}
	
	
}
