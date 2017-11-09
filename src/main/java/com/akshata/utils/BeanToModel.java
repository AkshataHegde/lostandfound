package com.akshata.utils;


import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.akshata.entities.UserModel;
import com.akshata.pojo.User;



@Component
public class BeanToModel {
	
	
	
	
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Autowired
	//BCryptPasswordEncoder bCryptPasswordEncoder;


	 public UserModel userBeanToModel( User user ) throws DataException
	    {
	        
	        try
	        {
	            
	            UserModel userModel = new UserModel();
	            userModel.setName(user.getName());
	            userModel.setPhoneNumber(user.getPhoneNumber());
	            userModel.setEmailId(user.getEmailId());
	            userModel.setAddress(user.getAddress());
	            userModel.setIsActive(true);
	           
	            userModel.setPassword(user.getPassword());
	        	
	            //userModel.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
	

	            return userModel;
	        }
	        catch(Exception e)
	        {
	            throw e;
	        }
	    }

	
}
