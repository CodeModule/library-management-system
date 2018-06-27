package com.fuseinterns.libraryManagementSystem.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/api/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(this.bookService.getAllBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<>(this.bookService.addBook(book), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        return new ResponseEntity<>(this.bookService.getBookById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@PathVariable String id , @RequestBody Book book){
        return new ResponseEntity<>(this.bookService.updateBook(id, book), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@PathVariable String id){
        return new ResponseEntity<>(this.bookService.deleteBook(id), HttpStatus.OK);
    }
}
