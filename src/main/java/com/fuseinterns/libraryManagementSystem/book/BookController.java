package com.fuseinterns.libraryManagementSystem.book;

import com.fuseinterns.libraryManagementSystem.finecalculator.FineCalculator;
import com.fuseinterns.libraryManagementSystem.user.User;
import com.fuseinterns.libraryManagementSystem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

@Autowired
private FineCalculator fineCalculator;

    @RequestMapping(value = "/api/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllBooks(@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password){
        User user = userService.getUserById(userId);
        if(user!=null && password.equals(user.getPassword())){
            return new ResponseEntity<>(this.bookService.getAllBooks(), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        }
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveBook(@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password, @RequestBody Book book){
        User user = userService.getUserById(userId);
        if(user!=null && user.getPassword().equals(password) && user.getRole().toLowerCase().equals("admin")){
            if(bookService.getBookById(book.getId())==null){
                return new ResponseEntity<>(this.bookService.addBook(book), HttpStatus.CREATED);

            }else{
                return new ResponseEntity<>(new Unauathorized(userId,"Book Already Exists (Duplicate ID)"),HttpStatus.CONFLICT);
            }

        }
        return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBookById(@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password,@PathVariable String id){
        User user = userService.getUserById(userId);
        if(user!=null && user.getPassword().equals(password)){
            return new ResponseEntity<>(Collections.singletonList(this.bookService.getBookById(id)), HttpStatus.OK);

        }
        return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBook(@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password,@PathVariable String id , @RequestBody Book book){
        User user = userService.getUserById(userId);
        if(user!=null && user.getPassword().equals(password) && user.getRole().toLowerCase().equals("admin")){
            this.bookService.updateBook(id, book);
            return new ResponseEntity<>(book, HttpStatus.CREATED);

        }
        return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBook(@RequestHeader(value = "userId")String userId,@RequestHeader(value = "password")String password,@PathVariable String id){
        User user = userService.getUserById(userId);
        if(user!=null && user.getPassword().equals(password) && user.getRole().toLowerCase().equals("admin")){
            return new ResponseEntity<>(this.bookService.deleteBook(id), HttpStatus.OK);

        }
        return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }
}
