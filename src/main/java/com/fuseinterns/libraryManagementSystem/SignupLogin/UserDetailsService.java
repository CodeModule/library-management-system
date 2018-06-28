package com.fuseinterns.libraryManagementSystem.SignupLogin;

import java.util.*;

import com.fuseinterns.libraryManagementSystem.SignupLogin.User;
import com.fuseinterns.libraryManagementSystem.SignupLogin.Role;
import com.fuseinterns.libraryManagementSystem.SignupLogin.UserRepository;
import com.fuseinterns.libraryManagementSystem.SignupLogin.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	
	//find user by email
	public User findUserByEmail(String email) {
	    return userRepository.findByEmail(email);
	}
	
	
	//save  user
	public void saveUser(User user) {
	    user.setPassword((user.getPassword()));
	    user.setEnabled(true);
	    Role userRole = roleRepository.findByRole("ADMIN");
	    user.setRoles(new HashSet<>(Arrays.asList(userRole)));
	    userRepository.save(user);
	}
	
	

}

