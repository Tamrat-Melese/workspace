package com.mpp.library.ui.view;

import com.mpp.library.controller.BookController;
import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FXHelper {
	
    public static ObservableList<Book> getObserverListOfBook(){
        ObservableList<Book> result = FXCollections.observableArrayList();
        BookController bookController = BookController.getInstance();
        for(Book book : bookController.getAll()){
            result.add(book);
        }
        return result;
    }

    public static ObservableList<BookCopy> getObserverListOfBookCopyOfBook(Book book){
        ObservableList<BookCopy> result = FXCollections.observableArrayList();
        for(BookCopy bookCopy : book.getBookCopies()){
            result.add(bookCopy);
        }
        return result;
    }

    public static void updateBookCopyList(ObservableList<BookCopy> list,  Book book){
        if(list == null) list = FXCollections.observableArrayList();
        list.clear();
        for(BookCopy bookCopy : book.getBookCopies()){
            list.add(bookCopy);
        }
    }
}
