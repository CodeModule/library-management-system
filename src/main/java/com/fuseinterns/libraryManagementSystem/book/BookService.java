package com.fuseinterns.libraryManagementSystem.book;


import com.fuseinterns.libraryManagementSystem.notification.NotificationEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        this.bookRepository.save(book);
        return book;
    }

    public List<Book> getBookByName(String name) {
        return this.bookRepository.findByName(name);
    }

    public Book getBookById(String id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
       

        return this.bookRepository.findAll();
    }

    public Book updateBook(String id, Book book) {
        this.bookRepository.findById(id).orElse(null);
        if(book!=null){
            this.bookRepository.save(book);
        }

        return null;
    }

    public Book deleteBook(String id) {
        Book book = this.bookRepository.findById(id).orElse(null);
        if (book != null)
            this.bookRepository.delete(book);
        return book;
    }
    
//    public void deleteCopies(String id) {
//        Book book = this.bookRepository.findById(id).orElse(null);
//        book.setQuantity(book.getQuantity()-1);
//       
//    }
}
