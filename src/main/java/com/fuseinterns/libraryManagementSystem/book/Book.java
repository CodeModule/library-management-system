package com.fuseinterns.libraryManagementSystem.book;


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
