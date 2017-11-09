package com.akshata.services;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.stereotype.Component;
import org.hibernate.exception.DataException;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.akshata.Repository.UserModelRepository;
import com.akshata.entities.UserModel;
import com.akshata.pojo.User;
import com.akshata.utils.BeanToModel;
import com.akshata.utils.Validator;

@Component
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRegistrationService {

	@Autowired
	private UserModelRepository userModelRepository;

	@Autowired
	private Validator validator;


	public String registerUser(User user) throws Exception {

		try {

			validator.validateRegistrationDetails(user);

			UserModel userModel = new UserModel();
			userModel.setName(user.getName());
			userModel.setPhoneNumber(user.getPhoneNumber());
			userModel.setEmailId(user.getEmailId());
			userModel.setAddress(user.getAddress());
			userModel.setIsActive(true);

			//userModel.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userModel.setPassword(user.getPassword());

			userModelRepository.save(userModel);

			return "User registered successfully";
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}

	}

}
