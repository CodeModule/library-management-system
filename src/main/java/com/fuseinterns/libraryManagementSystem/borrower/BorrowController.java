package com.fuseinterns.libraryManagementSystem.borrower;
 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fuseinterns.libraryManagementSystem.book.Book;
import com.fuseinterns.libraryManagementSystem.book.BookService;
import com.fuseinterns.libraryManagementSystem.user.UserService;



@RestController
public class BorrowController {
	@Autowired
	private BorrowService borrowService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/api/issue" , method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public void issueBooktoUser(@RequestBody BorroRequest borroRequest) {
		Book book = bookService.getBookById(borroRequest.getBookId());
		if(book!=null && book.getQuantity()>0) {
			book.issued();
			Borrow borrow = new Borrow();
			borrow.setBook(bookService.getBookById(borroRequest.getBookId()));
			borrow.setUser(userService.getUserById(borroRequest.getUserId()));
			borrow.setBorrowedDate(getCurrentdate());
			borrow.setReturnedDate(getDateAfterSpecificDays(7));
			
			borrowService.add(borrow);
		}
	
		  
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
