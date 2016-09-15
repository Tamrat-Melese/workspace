package com.mpp.library.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Book implements Entity {
    private String title;
    private String ISBN;
    private int borrowDuration;
    private List<Author> authorList;
    private List<BookCopy> bookCopies;

    public Book(String title, String ISBN, int borrowDuration) {
        this.title = title;
        this.ISBN = ISBN;
        this.borrowDuration = borrowDuration;
        this.authorList = new ArrayList<>();
        this.bookCopies = new ArrayList<>();
    }

	public Book(String ISBN, String title, int borrowDuration, List<Author> authors) {
		this.ISBN = ISBN;
		this.title = title;
		this.borrowDuration = borrowDuration;
		this.authorList = authors;
		bookCopies = new ArrayList<>();
	}

	@Override
	public String getID() {
		return ISBN;
	}

    public boolean addAuthor(Author author){
        return authorList.add(author);
    }

    public boolean addBookCopy(BookCopy bookCopy){
        return bookCopies.add(bookCopy);
    }

    public SimpleStringProperty titleProperty(){
        return new SimpleStringProperty(title);
    }

    public SimpleStringProperty ISBNProperty(){
        return new SimpleStringProperty(ISBN);
    }

    public SimpleStringProperty authorProperty(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Author author : authorList){
            stringBuilder.append(author.toString());
        }
        return new SimpleStringProperty(stringBuilder.toString());
    }

    public SimpleIntegerProperty borrowDurationProperty(){
        return new SimpleIntegerProperty(borrowDuration);
    }

    public SimpleIntegerProperty availabilityProperty(){
        return new SimpleIntegerProperty(availability());
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

	public int getBorrowDuration() {
		return borrowDuration;
	}

	public void setBorrowDuration(int borrowDuration) {
		this.borrowDuration = borrowDuration;
	}

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

	public int availability() {
        int availability = 0;
        for(BookCopy bookCopy : bookCopies){
            if(bookCopy.isAvailability()) availability += 1;
        }
        return availability;
	}
	
	public boolean isAvailabile() {
		return (availability() > 0);
	}

	public BookCopy getNextAvailableCopy() {
		for(BookCopy bookCopy : bookCopies){
            if(bookCopy.isAvailability()){
            	return bookCopy;
            }
        }
		return null;
	}
}
