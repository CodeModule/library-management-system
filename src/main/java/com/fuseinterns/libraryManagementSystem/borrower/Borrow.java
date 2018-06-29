package com.fuseinterns.libraryManagementSystem.borrower;

import java.util.Date;
import org.springframework.data.annotation.Id;
public class Borrow {
	
	@Id
	private String id;
	
	private int returned;
	
	public int getReturned() {
		return returned;
	}
	

	public void setReturned(int returned) {
		this.returned = returned;
	}
	
	private Date borrowedDate;
	private Date returnedDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}


	

}
