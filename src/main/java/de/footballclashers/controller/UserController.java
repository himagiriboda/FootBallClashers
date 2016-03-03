package de.footballclashers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.footballclashers.beans.Sucess;
import de.footballclashers.beans.GroupDetails;
import de.footballclashers.beans.Success;
import de.footballclashers.beans.UsersDetails;
import de.footballclashers.dao.interfaces.fbc.UserGroup;
import de.footballclashers.dao.model.fbc.Users;
import de.footballclashers.service.UsersService;
import de.footballclashers.service.ValidationService;

@RestController
@RequestMapping("/userManagement")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private UserGroup userGroup;
	
	@RequestMapping(value="/user",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Sucess userRegistration(@RequestBody Users users){
		usersService.doUserRegistration(users);
		Sucess sucess = new Sucess();
		sucess.setMessage("Success");
		sucess.setStatus(200);
		return sucess;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users>  getUserDetails(){
		List<Users> list = usersService.getAllUser();
		return list;
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users>  getUserDetails(@RequestParam(value="userName") String userName){
		System.out.println(userName);
		List<Users> list = usersService.getAllUser(userName);
		return list;
	}
	
	
	@RequestMapping(value="/forGot")
	public Success forGotPassword(@RequestParam(value="email") String email){
		usersService.doForGotPassword(email);
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}
	
	@RequestMapping(value="/change")
	public Success changePassword(@RequestParam(value="email") String email,@RequestParam(value="current") String current,@RequestParam(value="new") String newPassword){
		usersService.doChangePassword(email,current,newPassword);
		Success success = new Success();
		success.setMessage("Success");
		success.setStatus(200);
		return success;
	}

	@RequestMapping(value="/invitaions",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users> findInvitaions(@RequestParam(value="email") String email){
		return usersService.getListOfInvitations(email);
	}
	
	@RequestMapping(value="/logIn",method=RequestMethod.POST)
	public Sucess doLogIn(@RequestParam(value="email") String email,@RequestParam(value="password") String password){
		Users usersDetails = new Users();
		usersDetails.setEmail(email);
		usersDetails.setPassword(password);
		usersService.doLogIn(usersDetails);
		Success success = new Success();
		success.setMessage("Sucess");
		success.setStatus(200);
		return success;
	}
	
}
