package com.lostandfound.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lostandfound.entities.User;

@Repository
public interface UserModelRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmailIdAndIsActiveTrue(String emailId);

	Optional<User> findByPhoneNumberAndIsActiveTrue(String mobileNumber);
}
