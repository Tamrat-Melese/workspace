package com.mpp.library.entity;

import javafx.beans.property.SimpleStringProperty;

public class BookCopy {
    private Book book;
    private String copyNumber;
    private boolean availability;

    public BookCopy(Book book, String copyNumber) {
        this.book = book;
        this.copyNumber = copyNumber;
        this.availability = true;
    }

    public BookCopy(Book book, int copyNumber) {
        this.book = book;
        // TODO: copy number datatype
//        this.copyNumber = copyNumber;
        this.availability = true;
    }

	public SimpleStringProperty copyNumberProperty(){
        return new SimpleStringProperty(copyNumber);
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
