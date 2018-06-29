package com.fuseinterns.libraryManagementSystem.borrower;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface BorrowRepository extends MongoRepository<Borrow, Integer> {


}
