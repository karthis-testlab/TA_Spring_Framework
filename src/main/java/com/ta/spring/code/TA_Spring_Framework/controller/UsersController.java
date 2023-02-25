package com.ta.spring.code.TA_Spring_Framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ta.spring.code.TA_Spring_Framework.pojo.files.Users;
import com.ta.spring.code.TA_Spring_Framework.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping(path = "/api/users")
	public List<Users> getUsers(){
		return usersService.getAllUsers();
	}
	
	@GetMapping(path = "/api/user/{id}")
	public Users getUser(@PathVariable int id) {
		return usersService.getUser(id);
	}

}
