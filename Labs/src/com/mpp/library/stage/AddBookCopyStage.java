package com.mpp.library.stage;

import com.mpp.library.controller.BookController;
//import com.mpp.library.dataaccess.TestData;
import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;
import com.mpp.library.ui.controller.SceneController;
import com.mpp.library.ui.controller.SceneResource;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBookCopyStage extends Stage {
    private TableView<BookCopy> tableView;
    private Book selectedBook;
    private BookController instance = BookController.getInstance();

    public AddBookCopyStage(Stage owner, TableView<BookCopy> tableView, Book selectedBook) throws Exception{
        super();
        this.tableView = tableView;
        this.selectedBook = selectedBook;
        setTitle("Add new book copy");
        Parent root = SceneController.getInstance().loadLayout(SceneResource.NEW_BOOKCOPY_FXML);
        Scene scene = new Scene(root);
        setScene(scene);
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
    }

    public void addBookCopy(String copyNumber){
        BookCopy bookCopy = instance.addBookCopy(selectedBook, copyNumber);
        tableView.getItems().add(bookCopy);
    }
}
