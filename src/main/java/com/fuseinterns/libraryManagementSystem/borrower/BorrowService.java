package com.fuseinterns.libraryManagementSystem.borrower;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.fuseinterns.libraryManagementSystem.user.User;

@Service
public class BorrowService {
	
	

	
	@Autowired
	BorrowRepository borrowRepository;
	

	
	public Borrow add(Borrow b){
		
		borrowRepository.save(b);
		return b;
	}
	
	public List<Borrow> showIssued() {
		return borrowRepository.findAll();
	}
	
	
	public Borrow getBorrowById(String id) {
		return borrowRepository.findById(id).orElse(null);
	}
//	public void receiveBook(Book book) {
//		List<Borrow> borrows = borrowRepository.findByBookIdAndReturned(book, 0);
//		Borrow borrow = borrows.get(0);
//		borrowRepository.save(borrow);
//	}
public Borrow delete(Borrow b){

   borrowRepository.delete(b);
    return b;
	}

}
