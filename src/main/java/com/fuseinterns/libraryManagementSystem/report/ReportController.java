package com.fuseinterns.libraryManagementSystem.report;

import com.fuseinterns.libraryManagementSystem.book.Unauathorized;
import com.fuseinterns.libraryManagementSystem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ReportController {

@Autowired
private ReportBuilder reportBuilder;
@Autowired
private UserService userService;

    @RequestMapping(value = "api/{user}/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReport(@RequestHeader(value="userId") String userId, @RequestHeader(value = "password")String password, @PathVariable String user) {
        if(userService.getUserById(userId)!=null && userService.getUserById(userId).getPassword().equals(password)&& userService.getUserById(userId).getRole().equals(user)){
            return new ResponseEntity<>( reportBuilder.generateReport(), HttpStatus.OK);

        } else{
            return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.FORBIDDEN);
        }
    }
}
