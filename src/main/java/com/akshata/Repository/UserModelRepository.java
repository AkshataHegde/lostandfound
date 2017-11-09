package com.akshata.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akshata.entities.UserModel;

@Repository
public interface UserModelRepository extends CrudRepository<UserModel, Long> {
	
	
	 Optional<UserModel> findByEmailIdAndIsActiveTrue( String emailId );
	
	Optional<UserModel> findByPhoneNumberAndIsActiveTrue( String mobileNumber );
}
