package com.mpp.library.dataaccess;

import com.mpp.library.entity.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FXHelper {
    public static ObservableList<Book> getObserverListOfBook(){
        ObservableList<Book> result = FXCollections.observableArrayList();
        for(Book book : TestData.getInstanse().getBooks().getDataMap().values()){
            result.add(book);
        }
        return result;
    }
}
