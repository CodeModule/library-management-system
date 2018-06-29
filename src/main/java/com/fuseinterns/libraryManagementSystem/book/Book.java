package com.fuseinterns.libraryManagementSystem.book;

import com.fuseinterns.libraryManagementSystem.notification.NotificationEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.annotation.Id;


public class Book {

	@Id
	private String id;
	private String name;
	private String author;
	
	private String price;
	private int quantity;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
//	 public Book(String name, String author, String id, String price) {
//	        super();
//	        this.name = name;
//	        this.author = author;
//	        this.id = id;
//	        this.price = price;
//	    }
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {

		return quantity;
	}
	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}
	
}
