package com.fuseinterns.libraryManagementSystem.notification;

import com.fuseinterns.libraryManagementSystem.book.Unauathorized;
import com.fuseinterns.libraryManagementSystem.report.Report;
import com.fuseinterns.libraryManagementSystem.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/{user}/notifications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNotifications(@RequestHeader(value = "userId")String userId, @RequestHeader(value = "password")String password, @PathVariable String user) {
        if(userService.getUserById(userId)!=null && userService.getUserById(userId).getPassword().equals(password)&& userId.equals(user)){
            return new ResponseEntity<>(this.notificationService.getNotifications(user), HttpStatus.OK);

        } else{
            return new ResponseEntity<>(new Unauathorized(userId,"Unauthorized"), HttpStatus.FORBIDDEN);
        }
    }
}
