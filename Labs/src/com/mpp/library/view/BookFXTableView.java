package com.mpp.library.view;

import com.mpp.library.model.Book;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class BookFXTableView {
    private SimpleStringProperty ISBN;
    private SimpleStringProperty title;
    private SimpleBooleanProperty availability;

    public BookFXTableView(Book book){
        this.ISBN = new SimpleStringProperty(book.getISBN());
        this.title = new SimpleStringProperty(book.getTitle());
        this.availability = new SimpleBooleanProperty(book.isAvailability());
    }

    public String getISBN() {
        return ISBN.get();
    }

    public SimpleStringProperty ISBNProperty() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public boolean isAvailability() {
        return availability.get();
    }

    public SimpleBooleanProperty availabilityProperty() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability.set(availability);
    }
}
