package com.fuseinterns.libraryManagementSystem.borrower;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuseinterns.libraryManagementSystem.book.BookRepository;

//import com.fuseinterns.libraryManagementSystem.user.User;

@Service
public class BorrowService {
	Scanner sc = new Scanner(System.in);
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	static
	BorrowRepository borrowRepository;
	

	
	public Borrow add(Borrow b){
		return borrowRepository.save(b);
	}
	
	public boolean receiveBook(int id) {
		List<Borrow> borrows = borrowRepository.findByBookIdAndReturned(id, 0);
		Borrow borrow = borrows.get(0);
		borrowRepository.save(borrow);
		return true;
	}

}
