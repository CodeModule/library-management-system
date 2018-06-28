package com.fuseinterns.libraryManagementSystem.fineCalculator;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FineRepository extends MongoRepository<Fine,Integer> {

    Fine getByUserId (String userId);

}
