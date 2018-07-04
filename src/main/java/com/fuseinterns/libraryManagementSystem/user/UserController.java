package com.fuseinterns.libraryManagementSystem.user;

import java.util.List;

import com.fuseinterns.libraryManagementSystem.book.Unauathorized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fuseinterns.libraryManagementSystem.book.Book;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/user",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//note responseEntity is used to provide status 	
	public ResponseEntity<?> getAllUser(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password)
	{
		//note as ResponseEntity is used so new is a must
		User currentUser = userService.getUserById(userId);
		if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")) {
			return new ResponseEntity<>(this.userService.getAllUser(), HttpStatus.OK);		}
		return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

	}
	
	@RequestMapping(value="/api/user",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> saveUser(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password, @RequestBody User user)
	{
		User currentUser = userService.getUserById(userId);
		if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")) {
			this.userService.addUser(user);
			return new ResponseEntity<>(user,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

	}
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  void deleteUser(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password,@PathVariable String id){
		User currentUser = userService.getUserById(userId);
		if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")) {
			this.userService.deleteUser(id);
		}
    }
	
	 @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<?> getUserById(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password,@PathVariable String id){
		 User currentUser = userService.getUserById(userId);
		 if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")) {
			 return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
		 }
		 return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	    }

}
