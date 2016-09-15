package com.mpp.library.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BookCopy {
    private Book book;
    private int borrowDuration;
    private String copyNumber;
    private boolean availability;

    public BookCopy(Book book, int borrowDuration, String copyNumber) {
        this.book = book;
        this.borrowDuration = borrowDuration;
        this.copyNumber = copyNumber;
        this.availability = true;
    }

	public SimpleStringProperty copyNumberProperty(){
        return new SimpleStringProperty(copyNumber);
    }

    public SimpleIntegerProperty borrowDurationProperty(){
        return new SimpleIntegerProperty(borrowDuration);
    }

    public SimpleStringProperty statusProperty(){
        if(availability) return new SimpleStringProperty("available");
        else return new SimpleStringProperty("unavailable");
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }

    public void setBorrowDuration(int borrowDuration) {
        this.borrowDuration = borrowDuration;
    }

    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
