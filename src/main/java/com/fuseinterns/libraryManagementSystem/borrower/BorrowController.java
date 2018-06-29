package com.fuseinterns.libraryManagementSystem.borrower;
 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fuseinterns.libraryManagementSystem.book.Book;
import com.fuseinterns.libraryManagementSystem.book.BookService;
import com.fuseinterns.libraryManagementSystem.finecalculator.FineCalculator;
import com.fuseinterns.libraryManagementSystem.user.User;
import com.fuseinterns.libraryManagementSystem.user.UserService;



@RestController
public class BorrowController {
	@Autowired
	private BorrowService borrowService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	@Autowired
	private FineCalculator fineCalculator;
	@Autowired
	private ReturnRepository returnRepository;
	
	
	
	@RequestMapping(value = "/api/issue" , method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Borrow> issueBooktoUser(@RequestBody BorroRequest borroRequest) {
		Book book = bookService.getBookById(borroRequest.getBookId());
		User user = userService.getUserById(borroRequest.getUserId());
		if(book!=null && book.getQuantity()>0 && user!=null) {
			Borrow borrow = new Borrow();
			borrow.setId(book.getId()+user.getId());
			borrow.setBorrowedDate(getCurrentdate());
			borrow.setReturnedDate(getDateAfterSpecificDays(7));
			borrowService.add(borrow);
			book.setQuantity(book.getQuantity()-1);
			bookService.addBook(book);
			return new ResponseEntity<>(borrow,HttpStatus.CREATED);
		} 
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	
		  
	}
	
	@RequestMapping(value = "/api/return" , method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Return> returnBook(@RequestBody BorroRequest borroRequest) {
		Book book = bookService.getBookById(borroRequest.getBookId());
		Borrow borrow = borrowService.getBorrowById(borroRequest.getBookId()+borroRequest.getUserId());
		if (borrow!=null) {
			Return retun = new Return();
			retun.setBorrow(borrow);
			retun.setFine(fineCalculator.calculateFine(borrow.getReturnedDate()));
			retun.setActualReturnDate(new Date());
			returnRepository.save(retun);
			borrowService.delete(borrow);
			book.setQuantity(book.getQuantity()+1);
			bookService.addBook(book);
			return new ResponseEntity<>(retun,HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value = "/api/issue" , method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Borrow> getIssued() {
		
			return borrowService.showIssued();
	}
	 
	public Date getCurrentdate() {
		return new Date(new java.util.Date().getTime());
	}

	public Date getDateAfterSpecificDays(int days) {
		Date now = getCurrentdate();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DATE, days);

		return new Date(c.getTimeInMillis());

	}
}
