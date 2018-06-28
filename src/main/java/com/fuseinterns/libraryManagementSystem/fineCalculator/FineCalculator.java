package com.fuseinterns.libraryManagementSystem.fineCalculator;

import com.fuseinterns.libraryManagementSystem.notification.NotificationEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FineCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(FineCalculator.class);
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Scheduled(fixedRate = 30000)
    public void create() {
        final LocalDateTime start = LocalDateTime.now();
        this.applicationEventPublisher.publishEvent(new NotificationEvents(this, "Java Progrogramming", "Fine Due Rs. 5", "ishan"));

//            eventRepository.save(
//                    new Event(new EventKey("An event type", start, UUID.randomUUID()), Math.random() * 1000));
        LOG.debug("Event created!");
    }

}
