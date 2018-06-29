package com.fuseinterns.libraryManagementSystem.report;

import com.fuseinterns.libraryManagementSystem.book.Book;
import com.fuseinterns.libraryManagementSystem.user.User;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Report {

    @Id
    private String id;
    private String title;
    private Book book;
    private User user;
    private Date generatedDate;

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
