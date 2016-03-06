package de.footballclashers.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import de.footballclashers.beans.MatchesDetails;
import de.footballclashers.dao.model.fbc.Users;

public interface ValidationService {
	public boolean validateUser(Users users);
	public boolean isEmailAlreadyExisted(Users users);
	public boolean isUserRegisteredWithSocialID(Users users);
	public void isCurrentPasswordExisted(Users users);
	public void isUSerAuth(Users usersDetails);
	public List<MatchesDetails> findByListOfMatchesDetails(int group_id);
}
