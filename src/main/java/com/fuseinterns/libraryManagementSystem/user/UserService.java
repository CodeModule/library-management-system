package com.fuseinterns.libraryManagementSystem.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseinterns.libraryManagementSystem.book.Book;

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

//	public List<User> findByName(String firstName) {
//		return (List<User>)userRepository.findByFirstName(firstName);
//	}

	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}
	
	public User getUserById(String id) {
        return this.userRepository.findById(id).orElse(null);
    }

	// public void

}
