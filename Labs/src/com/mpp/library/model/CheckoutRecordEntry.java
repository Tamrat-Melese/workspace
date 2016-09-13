package com.mpp.library.model;

public class CheckoutRecordEntry {
    private BookCopy bookCopy;
    private Person person;

    public CheckoutRecordEntry(BookCopy bookCopy, Person person) {
        this.bookCopy = bookCopy;
        this.person = person;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
