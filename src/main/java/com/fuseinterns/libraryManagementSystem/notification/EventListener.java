package com.fuseinterns.libraryManagementSystem.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<NotificationEvents> {

    @Autowired
    private NotificationService notificationService;

    @Override
    public void onApplicationEvent(NotificationEvents event) {
        Notification notification = new Notification();
        notification.setTitle(event.getBookId());
        notification.setMessage(event.getMessage());
        notification.setBookId(event.getBookId());
        notification.setUser(event.getUser());
        this.notificationService.addNotification(notification);
    }
}
