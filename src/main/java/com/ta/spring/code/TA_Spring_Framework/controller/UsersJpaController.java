package com.ta.spring.code.TA_Spring_Framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta.spring.code.TA_Spring_Framework.pojo.files.Employees;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.Users;
import com.ta.spring.code.TA_Spring_Framework.service.UsersJpaService;

@RestController
@RequestMapping("/api")
public class UsersJpaController {
	
	@Autowired
	UsersJpaService usersJpaService;
	
	@GetMapping(path = "/jpa/users")
	public List<Users> getUsers(){
		return usersJpaService.getAllUsers();
	}
	
	@GetMapping(path = "/jpa/user/{id}")
	public Users getUser(@PathVariable int id) {
		return usersJpaService.getUser(id);
	}
	
	@PostMapping(path = "/jpa/add/user")
	public Users addUser(@RequestBody Users user) {
		return usersJpaService.addUser(user);
	}
	
	@PutMapping(path = "/jpa/update/user/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users users) {
		return ResponseEntity.ok().body(usersJpaService.updateUser(id, users));
	}
	
	@DeleteMapping(path = "/jpa/delete/user/{id}")
	public ResponseEntity<Employees> deleteUser(@PathVariable int id) {
		usersJpaService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
