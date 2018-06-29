package com.fuseinterns.libraryManagementSystem.borrower;

import java.util.Date;

public class Return{
	
	private Borrow borrow;
	private float fine;
	private Date actualReturnDate;
	public float getFine() {
		return fine;
	}
	public void setFine(float fine) {
		this.fine = fine;
	}
	public Date getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	public Borrow getBorrow() {
		return borrow;
	}
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
}
