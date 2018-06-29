package com.fuseinterns.libraryManagementSystem.borrower;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReturnRepository extends MongoRepository<Return, String>{

}
