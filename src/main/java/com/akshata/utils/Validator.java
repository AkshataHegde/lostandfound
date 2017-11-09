package com.akshata.utils;

import java.util.Optional;
import org.springframework.stereotype.Component;

import org.aspectj.apache.bcel.classfile.Constant;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.akshata.Repository.UserModelRepository;
import com.akshata.entities.UserModel;
import com.akshata.pojo.User;

@Component
public class Validator {
	
	
	@Autowired
	UserModelRepository userModelRepository;
	
	
    public void validateRegistrationDetails( User user ) throws Exception
    {
        if( null == user )
        {
        	throw new Exception("Name should not be Empty");
        }    
        if(  null == user.getPhoneNumber())
        {
            throw new Exception("Phone number field should not be empty");
        }
        if( user.getAddress().isEmpty() )
        {
            throw new Exception("Address field should not be empty ");
        }
        Optional<UserModel> userModelOptional = userModelRepository
                .findByPhoneNumberAndIsActiveTrue(user.getPhoneNumber());
        
        if( userModelOptional.isPresent() )
        {
            throw new Exception("Mobile number entered is already registered");
        }
        
        Optional<UserModel> userModelOpt = userModelRepository
                    .findByEmailIdAndIsActiveTrue(user.getEmailId().trim());
            if( userModelOpt.isPresent() )
            {
                throw new Exception("EmailId entered is already registered");
            }
        }
}   
      
    


