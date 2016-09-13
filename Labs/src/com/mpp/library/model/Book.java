package com.mpp.library.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String ISBN;
    private boolean availability;
    private List<Author> authors;
    private List<BookCopy> bookCopies;

    public Book(String title, String ISBN, boolean availability) {
        this.title = title;
        this.ISBN = ISBN;
        this.availability = availability;
        authors = new ArrayList<>();
        bookCopies = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }
}
