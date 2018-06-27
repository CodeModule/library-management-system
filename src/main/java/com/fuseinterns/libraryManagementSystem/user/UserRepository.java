package com.fuseinterns.libraryManagementSystem.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MainUser,String>{

	public User findOneByName(String name);
}

