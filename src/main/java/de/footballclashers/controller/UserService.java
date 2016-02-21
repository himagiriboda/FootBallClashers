package de.footballclashers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class UserService {
  public UserService() {
	  
  }
  @RequestMapping("/user")
  public void getUser() {
	  System.out.println("In user isssss");
  }
}
