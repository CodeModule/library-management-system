package com.fuseinterns.libraryManagementSystem.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseinterns.libraryManagementSystem.book.Book;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	//public User
	public void addUser(User user)
	{

		userRepository.save(user);
		
	}
		
	

	public void deleteUser(String id)
	{
		User user= userRepository.findByName(id);
		if(user!=null)
		userRepository.delete(user);
	}
	
	public User findByName(String name)
	{
		return userRepository.findByName(name);
	}
	
	public List<User> getAllUser()
	{
		return (List<User>) userRepository.findAll();
	}
		
	

	//public void





}

