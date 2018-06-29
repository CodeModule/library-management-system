package com.fuseinterns.libraryManagementSystem.report;


import com.fuseinterns.libraryManagementSystem.book.BookRepository;
import com.fuseinterns.libraryManagementSystem.borrower.BorrowRepository;
import com.fuseinterns.libraryManagementSystem.borrower.BorrowService;
import com.fuseinterns.libraryManagementSystem.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

@Autowired
private ReportBuilder reportBuilder;

    @RequestMapping(value = "api/{user}/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Report> getReport(@PathVariable String user) {

        return new ResponseEntity<>( reportBuilder.generateReport(), HttpStatus.OK);
    }
}
