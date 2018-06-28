package com.fuseinterns.libraryManagementSystem.fineCalculator;

import com.fuseinterns.libraryManagementSystem.borrower.Borrow;
import com.fuseinterns.libraryManagementSystem.borrower.BorrowService;
import com.fuseinterns.libraryManagementSystem.notification.NotificationEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class FineCalculator {

    @Autowired
    private FineService fineService;

    @Autowired
    private BorrowService borrowService;

    private static final Logger LOG = LoggerFactory.getLogger(FineCalculator.class);
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Scheduled(fixedRate = 30000)
    public void create() {
         for(Borrow borrow : borrowService.showIssued() ){
             System.out.println("Here");
             if (borrow.getReturnedDate().after(getCurrentdate())){

                 Fine fine = new Fine();
                 fine.setFine(5.0f);
                 try{
                     fine.setUserId(borrow.getUser().getId());
                     fine.setBookId(borrow.getBook().getId());
                     fineService.setFine(fine);
                     this.applicationEventPublisher.publishEvent(new NotificationEvents(this, fine.getBookId(), "Fine Due Rs. "+fine.getFine(), fine.getUserId()));

                 } catch(NullPointerException e){

                 }


             }
         }

//            eventRepository.save(
//                    new Event(new EventKey("An event type", start, UUID.randomUUID()), Math.random() * 1000));
    }

    public Date getCurrentdate() {
        return new Date(new java.util.Date().getTime());
    }
}
