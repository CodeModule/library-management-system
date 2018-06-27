package com.fuseinterns.libraryManagementSystem.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>{

	public User findByName(String name);
}


