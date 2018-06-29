package com.fuseinterns.libraryManagementSystem.report;

import com.fuseinterns.libraryManagementSystem.book.Book;

import java.util.List;

public class BookDetails {
    private List<Book> books;
    private int totalUniqueBooks;
    private  int totalBooks;


    public int getTotalBooks() {
        return totalBooks;
    }


    public BookDetails(List<Book> books) {
        this.books = books;
        this.totalUniqueBooks = books.size();
        for(Book book:books){
            this.totalBooks = this.totalBooks +book.getQuantity();
        }
    }

    public List<Book> getBooks() {
        return books;
    }



    public int getTotalUniqueBooks() {
        return totalUniqueBooks;
    }


}
