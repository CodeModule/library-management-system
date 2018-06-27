package com.fuseinterns.libraryManagementSystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseinterns.libraryManagementSystem.book.Book;

@Service
public class AdminService {

	@Autowired
	private UserRepository userRepository;

	//public User
	public void addBook(Book book)
	{

	}

}
