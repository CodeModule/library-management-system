package com.fuseinterns.libraryManagementSystem.user;

import java.util.List;

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
	public ResponseEntity<List<User>> getAllUser(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password)
	{
		//note as ResponseEntity is used so new is a must
		User currentUser = userService.getUserById(userId);
		if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")) {
			return new ResponseEntity<>(this.userService.getAllUser(), HttpStatus.OK);		}
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}
	
	@RequestMapping(value="/api/user",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE )
	public void saveUser(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password, @RequestBody User user)
	{
		
			this.userService.addUser(user);


	}
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  void deleteUser(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password,@PathVariable String id){
		User currentUser = userService.getUserById(userId);
		if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")) {
			this.userService.deleteUser(id);
		}
    }
	
	 @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<User> getUserById(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password,@PathVariable String id){
		 User currentUser = userService.getUserById(userId);
		 if(currentUser!=null && currentUser.getPassword().equals(password) && currentUser.getRole().toLowerCase().equals("admin")) {
			 return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
		 }
		 return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	    }

}
