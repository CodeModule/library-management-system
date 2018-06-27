package com.fuseinterns.libraryManagementSystem.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseinterns.libraryManagementSystem.book.Book;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	//public User
	public void addAdmin(Admin admin)
	{

		adminRepository.save(admin);
		
	}
		
	

	public void deleteAdmin(String id)
	{
		Admin admin= adminRepository.findByName(id);
		if(admin!=null)
		adminRepository.delete(admin);
	}
	
	public Admin findByName(String name)
	{
		return adminRepository.findByName(name);
	}
	
	public List<Admin> getAllAdmin()
	{
		return (List<Admin>) adminRepository.findAll();
	}
		
	

	//public void





}

