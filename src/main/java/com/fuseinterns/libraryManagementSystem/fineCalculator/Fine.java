package com.fuseinterns.libraryManagementSystem.fineCalculator;

public class Fine {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = this.fine+ fine;
    }

    private String userId;
    private float fine;
    private String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
