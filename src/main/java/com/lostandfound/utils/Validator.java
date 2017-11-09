package com.lostandfound.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lostandfound.Repository.UserModelRepository;
import com.lostandfound.bean.UserModel;
import com.lostandfound.entities.User;

@Component
public class Validator {

	@Autowired
	UserModelRepository userModelRepository;

	public void validateRegistrationDetails(UserModel user) throws Exception {
		
		if(null == user)
		{
			throw new Exception("Invalid input");
		}
		
		if (null == user.getName()) {
			throw new Exception("Name should not be Empty");
		}
		if (null == user.getPhoneNumber()) {
			throw new Exception("Phone number field should not be empty");
		}
		if (user.getAddress().isEmpty()) {
			throw new Exception("Address field should not be empty ");
		}
		Optional<User> userModelOptional = userModelRepository
				.findByPhoneNumberAndIsActiveTrue(user.getPhoneNumber());

		if (userModelOptional.isPresent()) {
			throw new Exception("Mobile number entered is already registered");
		}

		Optional<User> userModelOpt = userModelRepository.findByEmailIdAndIsActiveTrue(user.getEmailId().trim());
		if (userModelOpt.isPresent()) {
			throw new Exception("EmailId entered is already registered");
		}
	}
}
