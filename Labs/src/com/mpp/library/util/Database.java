package com.mpp.library.util;

import com.mpp.library.model.Book;
import com.mpp.library.view.BookFXTableView;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class Database {
    public static Map<String, Book> bookMap = getBooks();

    private static Map<String, Book> getBooks(){
        Map<String, Book> bs = new HashMap<>();

        Book[] books = {
                new Book("Book 1", "123456", Constant.AVAILABLE),
                new Book("Book 2", "543210", Constant.UNAVAILABLE),
                new Book("Book 3", "436226", Constant.AVAILABLE)
        };

        for(Book book : books){
            bs.put(book.getISBN(), book);
        }

        return bs;
    }

    public static ObservableList<BookFXTableView> data = DBHelper.getListOfBook(bookMap);
}
