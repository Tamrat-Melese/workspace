package com.mpp.library;

import com.mpp.library.controller.SceneController;
import com.mpp.library.controller.SceneResource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibraryApplication extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Library Management System");

        Parent root = SceneController.getInstance().loadLayout(SceneResource.MAIN_VIEW__FXML);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
