package de.footballclashers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.footballclashers.beans.Sucess;
import de.footballclashers.beans.UsersDetails;

@RestController
@RequestMapping("/userManagement")
public class UserController {
	
	@RequestMapping(value="/user",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void userRegistration(@RequestBody UsersDetails usersData){
		
	}
	@RequestMapping(value="/user", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UsersDetails>  getUserDetails(){
		List<UsersDetails> list = new ArrayList<UsersDetails>();
		return list;
	}
	
	@RequestMapping(value="/forGot")
	public Sucess forGotPassword(@RequestParam(value="email") String email){
		return null;
	}
	
	@RequestMapping(value="/change")
	public Sucess changePassword(@RequestParam(value="email") String email,@RequestParam(value="current") String current,@RequestParam(value="new") String newPassword){
		return null;
	}

	@RequestMapping(value="/invitaions",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UsersDetails> findInvitaions(@RequestParam(value="userID") String userID){
		return null;
	}
	
	@RequestMapping(value="/logIn",method=RequestMethod.POST)
	public Sucess doLogIn(@RequestParam(value="email") String email,@RequestParam(value="password") String password){
		return null;
	}
}
