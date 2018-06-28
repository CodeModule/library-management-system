package com.fuseinterns.libraryManagementSystem.notification;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification,Integer> {
    List<Notification> findByUser(String user);
}
