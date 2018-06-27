package com.fuseinterns.libraryManagementSystem.user;

import org.springframework.data.annotation.Id;

public class User implements MainUser{

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private double fine;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public User(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
