package com.fuseinterns.libraryManagementSystem.book.events;

import com.fuseinterns.libraryManagementSystem.notification.Notification;
import com.fuseinterns.libraryManagementSystem.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<BookEvents> {

    @Autowired
    private NotificationService notificationService;

    @Override
    public void onApplicationEvent(BookEvents event) {
        Notification notification = new Notification();
        notification.setTitle(event.getBookId());
        notification.setMessage(event.getMessage());
        notification.setBookId(event.getBookId());
        notification.setUser(event.getUser());
        this.notificationService.addNotification(notification);
    }
}
