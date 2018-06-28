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
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/api/admin",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//note responseEntity is used to provide status 	
	public ResponseEntity<List<Admin>> getAllAdmin()
	{
		//note as ResponseEntity is used so new is a must 
		return new ResponseEntity<>(this.adminService.getAllAdmin(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/admin",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE )
	public void saveAdmin(@RequestBody Admin admin)
	{
		adminService.addAdmin(admin);
	}
	
//	@RequestMapping(value = "/api/admin/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public  void deleteAdmin(@PathVariable String id){
//         adminService.deleteAdmin(id);
//    }

}
