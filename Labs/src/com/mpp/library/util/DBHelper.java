package com.mpp.library.util;

import com.mpp.library.entity.Book;
import com.mpp.library.view.BookFXTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;

public class DBHelper {

    public static ObservableList<BookFXTableView> getListOfBook(Map<String, Book> bookMap){
        ObservableList<BookFXTableView> bookTableModels = FXCollections.observableArrayList();

        for(String isbn : bookMap.keySet()){
            bookTableModels.add(new BookFXTableView(bookMap.get(isbn)));
        }
        return bookTableModels;
    }
}
