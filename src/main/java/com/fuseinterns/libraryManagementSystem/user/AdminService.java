package com.fuseinterns.libraryManagementSystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseinterns.libraryManagementSystem.book.Book;

@Service
public class AdminService {

	@Autowired
	private UserRepository userRepository;

	//public User
	public void addAdmin(Admin admin)
	{
<<<<<<< HEAD
		userRepository.save(admin);
		
	}
	
	public void deleteAdmin(Admin admin)
	{
		userRepository.delete(admin);
	}
	
	//public void
	
	
=======

	}

>>>>>>> 8dfe7e59b3d9f686d228d8f09be553d1c522fee5
}
