package com.fuseinterns.libraryManagementSystem.borrower;
 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fuseinterns.libraryManagementSystem.book.Book;
import com.fuseinterns.libraryManagementSystem.book.BookService;
import com.fuseinterns.libraryManagementSystem.finecalculator.FineCalculator;
import com.fuseinterns.libraryManagementSystem.notification.NotificationEvents;
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
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	
	
	@RequestMapping(value = "/api/issue" , method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> issueBooktoUser(@RequestBody BorroRequest borroRequest,@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password) {
		User currentUser = userService.getUserById(userId);
	    if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")){
			Book book = bookService.getBookById(borroRequest.getBookId());
			User user = userService.getUserById(borroRequest.getUserId());
			if(book!=null && book.getQuantity()>0 && user!=null) {
				Borrow borrow = new Borrow();
				borrow.setId(book.getId()+user.getId());
				borrow.setBorrowedDate(getCurrentdate());
				borrow.setReturnedDate(getDateAfterSpecificDays(7));
				borrowService.add(borrow);
	
				int quantity = book.getQuantity()-1;
				if(quantity==0){
					this.applicationEventPublisher.publishEvent(new NotificationEvents(this,book.getId(),"Book Out of Stock",currentUser.getId()));
	
				}
				book.setQuantity(quantity);
	
				bookService.addBook(book);
				return new ResponseEntity<>(borrow,HttpStatus.CREATED);
	
				
			} else{
				this.applicationEventPublisher.publishEvent(new NotificationEvents(this,book.getId(),"Book Out of Stock",user.getId()));
	
			}
			
			return new ResponseEntity<>(new Borrow(),HttpStatus.NOT_FOUND);
		
	    }else return new ResponseEntity<>("ADMIN Username or Password Wrong! Check the Credentials.",HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);  
	}
	
	@RequestMapping(value = "/api/return" , method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> returnBook(@RequestBody BorroRequest borroRequest,@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password) {
		User currentUser = userService.getUserById(userId);
	    if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")){
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
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    else return new ResponseEntity<>("ADMIN Username or Password Wrong! Check the Credentials.",HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
	
	
	@RequestMapping(value = "/api/issue" , method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getIssued(@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password) {
		User currentUser = userService.getUserById(userId);
	    if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")){
		
			return new ResponseEntity<>(borrowService.showIssued(),HttpStatus.FOUND);
	    }
	    return new ResponseEntity<>("ADMIN Username or Password Wrong! Check the Credentials.",HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
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
