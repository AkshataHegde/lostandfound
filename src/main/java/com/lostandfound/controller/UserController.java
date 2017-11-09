package com.lostandfound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lostandfound.bean.UserModel;
import com.lostandfound.services.UserRegistrationServiceImpl;

@RestController
@EnableAutoConfiguration
@RequestMapping("rest/user")
public class UserController {

	@Autowired
	private UserRegistrationServiceImpl userRegistrationService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String UserRegistration(@RequestBody UserModel user) throws Exception {
		try {
			return userRegistrationService.registerUser(user);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
