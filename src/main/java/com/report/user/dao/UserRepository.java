package com.report.user.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.report.user.domain.User;

/**
 * This mongodb repository is used to keep the user related collection.
 * @author root
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	/**
	 * This method fetch all users based on the userName
	 * @param userName
	 * @return
	 */
    public List<User> findByUserName(String userName);
}
