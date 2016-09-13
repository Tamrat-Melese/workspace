package com.mpp.library.model;

public class BookCopy {
    private Book book;
    private String copyNumber;

    public BookCopy(Book book, String copyNumber) {
        this.book = book;
        this.copyNumber = copyNumber;
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
}
