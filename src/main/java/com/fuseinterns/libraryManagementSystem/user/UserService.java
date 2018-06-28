package com.fuseinterns.libraryManagementSystem.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// public User
	public void addUser(User user) {

		userRepository.save(user);

	}

	public void deleteUser(String id) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null)
			userRepository.delete(user);
	}

	public List<User> findByName(String name) {
		return (List<User>)userRepository.findByfirstName(name);
	}

	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	// public void

}