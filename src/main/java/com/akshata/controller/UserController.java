package com.akshata.controller;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

import com.akshata.pojo.User;
import com.akshata.services.UserRegistrationService;

@RestController
@EnableAutoConfiguration
@RequestMapping("rest/user")
public class UserController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	  @RequestMapping( value = "/register", method = RequestMethod.POST )
	    public String UserRegistration(@RequestBody User user ) throws Exception
	        {
	            try
	            {
	                return userRegistrationService.registerUser(user);
	            }
	            catch (DataException e)
	            {
	                throw e;
	            }
	        }
	

}
