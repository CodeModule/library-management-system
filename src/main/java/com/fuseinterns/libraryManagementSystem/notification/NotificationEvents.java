package com.fuseinterns.libraryManagementSystem.notification;

import org.springframework.context.ApplicationEvent;

public class NotificationEvents extends ApplicationEvent {


    private String bookId;
    private String message;
    private String user;

    public String getUser() {
        return user;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NotificationEvents(Object source, String bookId, String message, String notify) {
        super(source);
        System.out.println("Book Evenets");
        this.bookId =bookId;
        this.message=message;
        this.user= notify;
    }



    public String getBookId() {
        return bookId;
    }

    public String getMessage() {
        return message;
    }


}