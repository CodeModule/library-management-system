package com.fuseinterns.libraryManagementSystem.user;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User implements Serializable{

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

	public User(String id, String firstName, String lastName,String email, double fine) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.fine=fine;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


}
