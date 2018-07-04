package com.fuseinterns.libraryManagementSystem.borrower;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowRepository extends MongoRepository<Borrow, String> {

	Borrow findById(Borrow borrows);


}
