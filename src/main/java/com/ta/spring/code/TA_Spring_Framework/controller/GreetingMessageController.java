package com.ta.spring.code.TA_Spring_Framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.Employees;
import com.ta.spring.code.TA_Spring_Framework.service.EmployeeService;


@RestController
public class GreetingMessageController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(path = "/api/message", method=RequestMethod.GET)
	public String get() {
		return "Welcome to microservice learning session";
	}
	
	@RequestMapping(path = "/api/employees", method=RequestMethod.GET)
	public List<Employees> getEmployees() {		
		return empService.getAllEmployees();
	}
	
	
	@RequestMapping(path = "/api/employee/{id}", method=RequestMethod.GET)
	public Employees getEmployee(@PathVariable int id) {		
		return empService.getEmployee(id);
	}
	

}
