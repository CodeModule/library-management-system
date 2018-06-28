package com.fuseinterns.libraryManagementSystem.borrower;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fuseinterns.libraryManagementSystem.book.Book;

public interface BorrowRepository extends MongoRepository<Borrow, Integer> {

	List<Borrow> findByBookIdAndReturned(Book book, int r);

	
	
}
