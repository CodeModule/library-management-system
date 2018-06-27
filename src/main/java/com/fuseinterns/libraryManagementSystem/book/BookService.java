package com.fuseinterns.libraryManagementSystem.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        this.bookRepository.save(book);
        return book;
    }

    public List<Book> getBookByName(String name){
        return this.bookRepository.findByName(name);
    }

    public Book getBookById(String id){
        return  this.bookRepository.findByBookId(id);
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

}
