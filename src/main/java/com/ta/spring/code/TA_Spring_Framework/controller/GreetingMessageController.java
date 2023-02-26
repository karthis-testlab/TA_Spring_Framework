package com.ta.spring.code.TA_Spring_Framework.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingMessageController {
	
	@RequestMapping(path = "/api/status", method=RequestMethod.GET)
	public String get() {
		return "Welcome to microservice learning session";
	}
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping(path = "/api/welcome")
	public String i18nMessage() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("welcome.message", null, "Hi! Welcome", locale);
	}

}