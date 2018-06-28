package com.fuseinterns.libraryManagementSystem.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getNotifications(String user) {

        return notificationRepository.findByUser(user);
    }
    public void addNotification(Notification notification){
        this.notificationRepository.save(notification);
    }
}
