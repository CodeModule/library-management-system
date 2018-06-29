package com.fuseinterns.libraryManagementSystem.report;

import com.fuseinterns.libraryManagementSystem.book.BookRepository;
import com.fuseinterns.libraryManagementSystem.borrower.BorrowRepository;
import com.fuseinterns.libraryManagementSystem.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReportBuilder {

    //TODO:Change to borrow servie
    @Autowired
    private BorrowRepository borrowRepository;
//end of TODO

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Report generateReport() {
        Report report = new Report();
        report.setId("REP-17-5");
        report.setBookDetails(new BookDetails(bookRepository.findAll()));
        report.setUserDetails(new UserDetails(userRepository.findAll()));
        report.setTransactionDetails(new TransactionDetails(borrowRepository.findAll(), borrowRepository.findAll()));
        report.setGeneratedDate(new Date());
        return report;
    }
}
