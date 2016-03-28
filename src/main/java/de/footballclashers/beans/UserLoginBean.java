package de.footballclashers.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import de.footballclashers.dao.model.fbc.Users;

@JsonInclude(Include.NON_EMPTY)
public class UserLoginBean {
	private Success success;
	private Users userDetails;
	public Success getSuccess() {
		return success;
	}
	public void setSuccess(Success success) {
		this.success = success;
	}
	public Users getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Users userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
 