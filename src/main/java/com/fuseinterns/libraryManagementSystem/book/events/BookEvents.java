package com.fuseinterns.libraryManagementSystem.book.events;

import org.springframework.context.ApplicationEvent;

public class BookEvents extends ApplicationEvent {


    private String bookId;
    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BookEvents(Object source,String bookId, String message) {
        super(source);
        System.out.println("Book Evenets");
        this.bookId =bookId;
        this.message=message;
    }



    public String getBookId() {
        return bookId;
    }

    public String getMessage() {
        return message;
    }


}