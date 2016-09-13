package com.mpp.library.model;

import com.mpp.library.exception.BookExistedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String name;
    private Map<String, Book> books;
    private List<CheckoutRecord> checkoutRecords;

    public Library(String name) {
        this.name = name;
        books = new HashMap<>();
        checkoutRecords = new ArrayList<>();
    }

    public void addCheckoutRecord(CheckoutRecord record){
        checkoutRecords.add(record);
    }

    public void addBook(Book b) throws BookExistedException {
        if(books.keySet().contains(b.getISBN())) throw new BookExistedException("Another book with ISBN " + b.getISBN() + "is already existed");

        books.put(b.getISBN(), b);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public List<CheckoutRecord> getCheckoutRecords() {
        return checkoutRecords;
    }

    public void setCheckoutRecords(List<CheckoutRecord> checkoutRecords) {
        this.checkoutRecords = checkoutRecords;
    }
}
