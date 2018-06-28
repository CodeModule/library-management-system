package com.fuseinterns.libraryManagementSystem.borrower;

import com.fuseinterns.libraryManagementSystem.book.*;
import com.fuseinterns.libraryManagementSystem.user.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Borrow {
	
	
	@Id
    private int id;
	private int returned;
	
	
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
	
	private User user;
	
	
	private Book book;
	
	private Date borrowedDate;
	private Date returnDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
	

}
