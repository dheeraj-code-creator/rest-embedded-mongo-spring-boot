package com.rest.mongo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.mongo.entity.User;
import com.rest.mongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<User>();
		User userObj1 = new User("101", "Mongo one");
		User userObj2 = new User("201", "Mongo two");
		userList.add(userObj1);
		userList.add(userObj2);
		userRepository.saveAll(userList);
		return userRepository.findAll();
	}

	public User getUserByUserId(String userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User updateUserInfo(String userId, User users) {
		User existingUserId = userRepository.findById(userId).orElse(null);
		existingUserId.setUserId(users.getUserId());
		existingUserId.setUserName(users.getUserName());
		return userRepository.save(existingUserId);
	}

	public User createNewUser(User users) {
		User objUser = new User();
		objUser.setUserId(users.getUserId());
		objUser.setUserName(users.getUserName());
		return userRepository.save(objUser);
	}

}
