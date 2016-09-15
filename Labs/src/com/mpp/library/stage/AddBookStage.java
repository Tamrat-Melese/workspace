package com.mpp.library.stage;

import com.mpp.library.controller.BookController;
import com.mpp.library.entity.Book;
import com.mpp.library.entity.LoggedUser;
import com.mpp.library.ui.controller.SceneController;
import com.mpp.library.ui.controller.SceneResource;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBookStage extends Stage{

    private BookController instance = BookController.getInstance();

    public AddBookStage(Stage owner) throws Exception {
        super();
        Parent root = SceneController.getInstance().loadLayout(SceneResource.NEW_BOOK_FXML);
        Scene scene = new Scene(root);
        setScene(scene);
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
    }

    public void addBook(String ISBN, String title, int borrowDuration) throws Exception{
        Book book = instance.addBook(ISBN, title, borrowDuration);
        LoggedUser.getInstance().loadBookTab();
    }
}
