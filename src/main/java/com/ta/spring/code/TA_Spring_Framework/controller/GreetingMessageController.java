package com.ta.spring.code.TA_Spring_Framework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingMessageController {
	
	@RequestMapping(path = "/api/status", method=RequestMethod.GET)
	public String get() {
		return "Welcome to microservice learning session";
	}

}