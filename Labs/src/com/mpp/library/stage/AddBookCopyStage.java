package com.mpp.library.stage;

import com.mpp.library.dataaccess.TestData;
import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBookCopyStage extends Stage {
    private TableView<BookCopy> tableView;
    private Book selectedBook;

    public AddBookCopyStage(Stage owner, TableView<BookCopy> tableView, Book selectedBook) throws Exception{
        this.tableView = tableView;
        this.selectedBook = selectedBook;
        setTitle("Add new book copy");
        Parent root = FXMLLoader.load(getClass().getResource("../view/NewBookCopyView.fxml"));
        Scene scene = new Scene(root);
        setScene(scene);
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
    }

    public void addBookCopy(String copyNumber, String borrowDuration){
        BookCopy bookCopy = new BookCopy(selectedBook,Integer.parseInt(borrowDuration), copyNumber);
        tableView.getItems().add(bookCopy);
        TestData.getInstanse().addNewBookCopy(selectedBook, bookCopy);
    }
}
