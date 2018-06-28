package com.fuseinterns.libraryManagementSystem.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/user",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//note responseEntity is used to provide status 	
	public ResponseEntity<List<User>> getAllUser()
	{
		//note as ResponseEntity is used so new is a must 
		return new ResponseEntity<>(this.userService.getAllUser(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/user",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE )
	public void saveUser(@RequestBody User user)
	{
		this.userService.addUser(user);
	}
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  void deleteUser(@PathVariable String id){
         this.userService.deleteUser(id);
    }

}
