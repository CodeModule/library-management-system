package com.fuseinterns.libraryManagementSystem.user;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends MongoRepository<User,String>{


}


